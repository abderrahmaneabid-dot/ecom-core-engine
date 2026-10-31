package com.abdo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Had les annotations d-Jackson kaykhlliwh yfhem l-héritage f-JSON
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhysicalProduct.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = DigitalProduct.class, name = "DIGITAL")
})
public abstract class Product {
    private String id;
    private String name;
    private double basePrice;

    // Constructeur par défaut khasso Jackson bach y-deserialisi
    public Product() {
    }

    public Product(String id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    // Méthode abstraite: kol sous-classe kat7seb l-prix final b-tariqatha
    public abstract double calculateFinalPrice();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}