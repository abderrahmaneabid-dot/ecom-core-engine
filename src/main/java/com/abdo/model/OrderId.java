package com.abdo.model;

import java.util.Objects;
import java.util.UUID;

// 'final' class: ma ymkench chi classe t-weret menha
public final class OrderId {
    private final String value;

    public OrderId() {
        this.value = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public OrderId(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("OrderId cannot be null or empty");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // HashCode w-Equals daroriyin bach nsta3mloha comme clé f-Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderId orderId = (OrderId) o;
        return Objects.equals(value, orderId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}