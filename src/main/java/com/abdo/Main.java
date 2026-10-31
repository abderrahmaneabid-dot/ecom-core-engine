package com.abdo;

import com.abdo.model.*;
import com.abdo.repository.CrudRepository;
import com.abdo.repository.InMemoryRepository;
import com.abdo.service.DiscountStrategy;
import com.abdo.service.JsonStorageService;
import com.abdo.service.OrderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== CATALOGUE DES PRODUITS ======\n");
        CrudRepository<Product, String> productRepo = new InMemoryRepository<>(Product::getId);

        // Ajout des Produits
        Product watch = new PhysicalProduct("P101", "Smartwatch Ultra", 450.0, 0.35, 30.0);
        Product blender = new PhysicalProduct("P102", "Mini Blender Pro", 220.0, 1.2, 25.0);
        Product ebook = new DigitalProduct("P201", "Mastering Java E-Book", 99.0, "https://abdo.dev/downloads/java-guide.pdf", 0.05);

        productRepo.save(watch);
        productRepo.save(blender);
        productRepo.save(ebook);

        // Affichage dyal l-produits kamlin
        System.out.println("[+] Liste des produits:");
        for (Product p : productRepo.findAll()) {
            System.out.println("  - " + p.getName() + " (ID: " + p.getId() + ") | Prix Final: " + p.calculateFinalPrice() + " DH");
        }

//        System.out.println("====== DEMARRAGE DU CORE ENGINE E-COMMERCE ======\n");
//
//        // 1. Initialisation des Repositories (Generics + Method Reference)
//        CrudRepository<Product, String> productRepo = new InMemoryRepository<>(Product::getId);
//
//
//        //CrudRepository<Order, OrderId> orderRepo = new InMemoryRepository<>(Order::getId);
//
//        // 2. Initialisation des Services
////        OrderService orderService = new OrderService(orderRepo, productRepo);
////        JsonStorageService jsonStorageService = new JsonStorageService();
//
//        // 3. Ajout des Produits (Polymorphism: Physical vs Digital)
//        Product watch = new PhysicalProduct("P101", "Smartwatch Ultra", 450.0, 0.35, 30.0);
//        Product blender = new PhysicalProduct("P102", "Mini Blender Pro", 220.0, 1.2, 25.0);
//        Product ebook = new DigitalProduct("P201", "Mastering Java E-Book", 99.0, "https://abdo.dev/downloads/java-guide.pdf", 0.05);
//
//        productRepo.save(watch);
//        productRepo.save(blender);
//        productRepo.save(ebook);
//
//        System.out.println("[+] Produits ajoutes au catalogue:");
//        productRepo.findAll().forEach(p ->
//                System.out.println("  - " + p.getName() + " | Prix Final: " + p.calculateFinalPrice() + " DH")
//        );

//        try {
//            // 4. Creation de commandes
//            OrderId order1Id = new OrderId();
//            Order order1 = new Order(order1Id, "client.vip@gmail.com");
//            orderRepo.save(order1);
//
//            OrderId order2Id = new OrderId();
//            Order order2 = new Order(order2Id, "customer.casa@yahoo.com");
//            orderRepo.save(order2);
//
//            // Ajout des items
//            orderService.addProductToOrder(order1Id, "P101");
//            orderService.addProductToOrder(order1Id, "P201");
//
//            orderService.addProductToOrder(order2Id, "P102");
//
//            System.out.println("\n[+] Total Commande 1 (Avant Promo): " + order1.getSubTotal() + " DH");

//            // 5. Functional Programming: Promo 10% si total > 400 DH
//            Predicate<Order> over400DhCondition = o -> o.getSubTotal() > 400.0;
//            DiscountStrategy percentage10Strategy = o -> o.getSubTotal() * 0.10;
//
//            orderService.applyPromotion(order1Id, over400DhCondition, percentage10Strategy);
//            System.out.println("[+] Total Commande 1 (Apres Promo): " + order1.getTotalPrice() + " DH (Remise: " + order1.getDiscountAmount() + " DH)");
//
//            // 6. Consumer Notification & Paiement
//            Consumer<Order> emailNotifier = o ->
//                    System.out.println("[EMAIL NOTIFICATION] Commande #" + o.getId() + " payee avec succes par " + o.getCustomerEmail() + "! Total debite: " + o.getTotalPrice() + " DH");
//
//            System.out.println("\n--- Traitement des Paiements ---");
//            orderService.processPayment(order1Id, emailNotifier);
//            orderService.processPayment(order2Id, emailNotifier);

//            // 7. Java Streams API: Reporting
//            System.out.println("\n--- Business Reports (Java Streams) ---");
//            System.out.println("Chiffre d'Affaires Total (PAID): " + orderService.calculateTotalRevenue() + " DH");

//            List<Order> topOrders = orderService.getTopValuedOrders(2);
//            System.out.println("Top " + topOrders.size() + " des Commandes:");
//            topOrders.forEach(o -> System.out.println("  * Commande #" + o.getId() + " -> " + o.getTotalPrice() + " DH"));

            // 8. Jackson Persistence: Sauvegarde JSON
//            jsonStorageService.saveToFile("products.json", productRepo.findAll());
//            jsonStorageService.saveToFile("orders.json", orderRepo.findAll());
//            System.out.println("\n[+] Donnees exportees avec succes vers 'products.json' et 'orders.json' !");
//
//        } catch (Exception e) {
//            System.err.println("Erreur: " + e.getMessage());
//        }
    }
}