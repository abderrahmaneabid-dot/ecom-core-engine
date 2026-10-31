package com.abdo.model;

public class DigitalProduct extends Product {

    private String downloadUrl;
    private double digitalVatRate;

    public DigitalProduct() {
        super();
    }

    public DigitalProduct(String id, String name, double basePrice, String downloadUrl, double digitalVatRate) {
        super(id, name, basePrice);
        this.downloadUrl = downloadUrl;
        this.digitalVatRate = digitalVatRate;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() * (1 + digitalVatRate);
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getDigitalVatRate() {
        return digitalVatRate;
    }

    public void setDigitalVatRate(double digitalVatRate) {
        this.digitalVatRate = digitalVatRate;
    }


}
