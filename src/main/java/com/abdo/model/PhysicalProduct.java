package com.abdo.model;

public class PhysicalProduct extends Product {
    private double WeightInKg;
    private double shippingCostInKg;

    public PhysicalProduct() {
        super();
    }

    public PhysicalProduct(String id, String name, double BasePrice, double WeightInKg, double shippingCostInKg) {
        super(id,name,BasePrice);
        this.WeightInKg = WeightInKg;
        this.shippingCostInKg = shippingCostInKg;
    }

    public double getWeightInKg() {
        return WeightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.WeightInKg = weightInKg;
    }

    public double getShippingCostInKg() {
            return shippingCostInKg;
    }

    public void setShippingCostInKg(double shippingCostInKg) {
        this.shippingCostInKg = shippingCostInKg;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + (shippingCostInKg * WeightInKg);
    }
}
