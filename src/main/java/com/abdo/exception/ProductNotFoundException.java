package com.abdo.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String productId) {
        super("Le produit avec l'identifiant '" + productId + "' est introuvable !");
    }
}