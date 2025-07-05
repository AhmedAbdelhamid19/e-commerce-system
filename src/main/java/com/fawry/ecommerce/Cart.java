package com.fawry.ecommerce;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new LinkedHashMap<>();

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be positive");
            return;
        }
        if (quantity > product.getQuantity()) {
            System.out.println("Error: Not enough stock for " + product.getName());
            return;
        }
        int current = items.getOrDefault(product, 0);
        if (current + quantity > product.getQuantity()) {
            System.out.println("Error: Not enough stock for " + product.getName());
            return;
        }
        items.put(product, current + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) return "Cart is empty";
        StringBuilder sb = new StringBuilder();
        for (var entry : items.entrySet()) {
            sb.append(entry.getValue()).append("x ").append(entry.getKey().getName()).append("\t");
            sb.append(entry.getKey().getPrice() * entry.getValue()).append("\n");
        }
        return sb.toString();
    }
} 