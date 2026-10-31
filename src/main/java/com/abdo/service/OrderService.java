package com.abdo.service;

import com.abdo.exception.OrderProcessingException;
import com.abdo.exception.ProductNotFoundException;
import com.abdo.model.Order;
import com.abdo.model.OrderId;
import com.abdo.model.OrderStatus;
import com.abdo.model.Product;
import com.abdo.repository.CrudRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class OrderService {

    private final CrudRepository<Order, OrderId> orderRepository;
    private final CrudRepository<Product, String> productRepository;

    public OrderService(CrudRepository<Order, OrderId> orderRepository,
                        CrudRepository<Product, String> productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // 1. Ziyadat produit l-commande b-isti3mal Optional & Custom Exception
    public void addProductToOrder(OrderId orderId, String productId) throws OrderProcessingException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderProcessingException("Commande introuvable avec ID: " + orderId));

        if (order.getStatus() != OrderStatus.PENDING) {
            throw new OrderProcessingException("Impossible de modifier une commande déjà traitée !");
        }

        // ila l-produit makaynsh, kankherjo b-ProductNotFoundException direct
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        order.addProduct(product);
        orderRepository.save(order);
    }

    // 2. Tatbiq remise b-sti3mal Predicate w-Functional Interface (DiscountStrategy)
    public void applyPromotion(OrderId orderId, Predicate<Order> eligibilityCondition, DiscountStrategy discountStrategy) throws OrderProcessingException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderProcessingException("Commande introuvable avec ID: " + orderId));

        // Predicate.test() kay-verifi wach l-commande wafe9t ch-chart
        if (eligibilityCondition.test(order)) {
            double discount = discountStrategy.applyDiscount(order);
            order.setDiscountAmount(discount);
            orderRepository.save(order);
        }
    }

    // 3. Traitement dyal l-khalas b-Consumer (Simulation notification)
    public void processPayment(OrderId orderId, Consumer<Order> receiptNotifier) throws OrderProcessingException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderProcessingException("Commande introuvable avec ID: " + orderId));

        if (order.getItems().isEmpty()) {
            throw new OrderProcessingException("Impossible de payer une commande vide !");
        }

        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);

        // Consumer.accept() kay-sift l-notification
        receiptNotifier.accept(order);
    }

    // 4. Java Streams: Filtrage par Statut
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getStatus() == status)
                .toList();
    }

    // 5. Java Streams: Calcul du Chiffre d'Affaires total (Commandes PAID)
    public double calculateTotalRevenue() {
        return orderRepository.findAll().stream()
                .filter(order -> order.getStatus() == OrderStatus.PAID)
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    // 6. Java Streams: Classement des commandes les plus chères
    public List<Order> getTopValuedOrders(int limit) {
        return orderRepository.findAll().stream()
                .sorted(Comparator.comparing(Order::getTotalPrice).reversed())
                .limit(limit)
                .toList();
    }

    public Optional<Order> getOrderById(OrderId id) {
        return orderRepository.findById(id);
    }
}