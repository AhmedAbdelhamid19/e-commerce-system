package com.fawry.ecommerce;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new LinkedHashMap<>();

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (quantity > product.getQuantity()) throw new IllegalArgumentException("Not enough stock for " + product.getName());
        int current = items.getOrDefault(product, 0);
        if (current + quantity > product.getQuantity()) throw new IllegalArgumentException("Not enough stock for " + product.getName());
        items.put(product, current + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
} 