package com.abdo.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private OrderId id;
    private String customerEmail;
    private List<Product> items;
    private OrderStatus status;
    private double discountAmount;

    public Order() {
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.discountAmount = 0.0;
    }

    public Order(OrderId id, String customerEmail) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.discountAmount = 0.0;
    }

    public void addProduct(Product product) {
        if (product != null) {
            this.items.add(product);
        }
    }

    // Calcul du sous-total du panier bla remises
    public double getSubTotal() {
        return items.stream()
                .mapToDouble(Product::calculateFinalPrice)
                .sum();
    }

    // Calcul dyal l-total l-kamel après remise (Ternary Operator)
    public double getTotalPrice() {
        double total = getSubTotal() - discountAmount;
        return total > 0 ? total : 0.0;
    }

    public OrderId getId() {
        return id;
    }

    public void setId(OrderId id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", email='" + customerEmail + '\'' +
                ", itemsCount=" + items.size() +
                ", total=" + getTotalPrice() +
                ", status=" + status +
                '}';
    }
}