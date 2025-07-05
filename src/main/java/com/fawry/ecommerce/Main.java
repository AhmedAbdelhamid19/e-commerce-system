package com.fawry.ecommerce;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== FAWRY E-COMMERCE SYSTEM Task ===\n");

        // This Products Will Be Used In Test Cases
        Cheese cheese = new Cheese("Cheese", 100, 10, 0.4, false);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, 0.7, false);
        TV tv = new TV("TV", 5000, 3, 10.0);
        Mobile mobile = new Mobile("Mobile", 3000, 8);
        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 20);

        // Test Case 1: Normal Checkout (Everything Is Ok)
        System.out.println("Test Case 1: Normal Checkout");
        Customer customer = new Customer("Fawry Customer #1", 20000);
        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 3);
        cart.addProduct(scratchCard, 1);
        CheckoutService.checkout(customer, cart);
        System.out.println("\n________________________________\n");

        // Test Case 2: Empty Cart
        System.out.println("Test Case 2: Empty Cart");
        Customer customer2 = new Customer("Fawry Customer #2", 1000);
        Cart emptyCart = new Cart();
        CheckoutService.checkout(customer2, emptyCart);
        System.out.println("\n________________________________\n");

        // Test Case 3: Insufficient Balance & Cart Is Empty
        System.out.println("Test Case 3: Insufficient Balance");
        Customer poorCustomer = new Customer("Fawry Customer #3", 100);
        Cart expensiveCart = new Cart();
        expensiveCart.addProduct(tv, 1);
        CheckoutService.checkout(poorCustomer, expensiveCart);
        System.out.println("\n________________________________\n");

        // Test Case 4: Expired Product
        System.out.println("Test Case 4: Expired Product");
        Cheese expiredCheese = new Cheese("Expired Cheese", 100, 5, 0.4, true);
        Customer customer3 = new Customer("Fawry Customer #4", 1000);
        Cart expiredCart = new Cart();
        expiredCart.addProduct(expiredCheese, 1);
        CheckoutService.checkout(customer3, expiredCart);
        System.out.println("\n________________________________\n");

        // Test Case 5: Out of Stock & Cart Is Empty
        System.out.println("Test Case 5: Out of Stock");
        Cheese lowStockCheese = new Cheese("Low Stock Cheese", 100, 1, 0.4, false);
        Customer customer4 = new Customer("Fawry Customer #5", 1000);
        Cart stockCart = new Cart();
        stockCart.addProduct(lowStockCheese, 2);
        CheckoutService.checkout(customer4, stockCart);
        System.out.println("\n________________________________\n");

        // Test Case 6: Mixed Products (Shippable and Non-Shippable)
        System.out.println("Test Case 6: Mixed Products (Shippable and Non-Shippable)");
        Customer customer5 = new Customer("Mixed Customer", 10000);
        Cart mixedCart = new Cart();
        mixedCart.addProduct(cheese, 2); // Shippable, expirable
        mixedCart.addProduct(biscuits, 1); // Shippable, expirable
        mixedCart.addProduct(mobile, 1); // Non-shippable, non-expirable
        mixedCart.addProduct(scratchCard, 3); // Non-shippable, non-expirable
        CheckoutService.checkout(customer5, mixedCart);
        System.out.println("\n________________________________\n");

        System.out.println("Test Done, I Hope To Join This Internship \nAhmed Abdelhamid");
    }
}