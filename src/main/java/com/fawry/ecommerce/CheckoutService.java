package com.fawry.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }
        double subtotal = 0;
        double shipping = 0;
        double totalWeight = 0;
        boolean hasError = false;
        List<Shippable> shippableItems = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            // Check for expirable
            if (product instanceof Expirable) {
                if (((Expirable) product).isExpired()) {
                    System.out.println("Error: Product '" + product.getName() + "' is expired");
                    hasError = true;
                }
            }
            // Check for stock
            if (qty > product.getQuantity()) {
                System.out.println("Error: Product '" + product.getName() + "' is out of stock");
                hasError = true;
            }
            subtotal += product.getPrice() * qty;
            // Shipping
            if (product instanceof Shippable) {
                double weight = ((Shippable) product).getWeight() * qty;
                shipping += 15 * qty; // Example: 15 per shippable item
                totalWeight += weight;
                // Add shippable items to the list
                for (int i = 0; i < qty; i++) {
                    shippableItems.add((Shippable) product);
                }
            }
        }
        if (hasError) return;
        double total = subtotal + shipping;
        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance");
            return;
        }
        // Deduct balance and reduce stock
        customer.deductBalance(total);
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }
        // Send shippable items to shipping service
        ShippingService.shipItems(shippableItems);
        // Print receipt
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName() + "\t" + (entry.getKey().getPrice() * entry.getValue()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t\t" + subtotal);
        System.out.println("Shipping\t\t" + shipping);
        System.out.println("Amount\t\t" + total);
        System.out.println("Customer balance after payment: " + customer.getBalance());
    }
} 