package com.abdo.service;

import com.abdo.model.Order;

@FunctionalInterface
public interface DiscountStrategy {
    // Méthode unique abstraite: katakhod Order w-kat-rejje3 le montant du discount
    double applyDiscount(Order order);
}