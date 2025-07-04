package com.fawry.ecommerce;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== FAWRY E-COMMERCE SYSTEM Task ===\n");

        // Products will be used to test
        Cheese cheese = new Cheese("Cheese", 100, 10, 0.4, false);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, 0.7, false);
        TV tv = new TV("TV", 5000, 3, 10.0);
        Mobile mobile = new Mobile("Mobile", 3000, 8);
        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 20);

        // Test Case 1: Normal Checkout (as per requirements)
        System.out.println("TEST CASE 1: Normal Checkout");
        Customer customer = new Customer("John Doe", 20000);
        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 3);
        cart.addProduct(scratchCard, 1);
        CheckoutService.checkout(customer, cart);
        System.out.println("\n________________________________\n");

        // Test Case 2: Empty Cart Error
        System.out.println("TEST CASE 2: Empty Cart Error");
        Customer customer2 = new Customer("Jane Smith", 1000);
        Cart emptyCart = new Cart();
        CheckoutService.checkout(customer2, emptyCart);
        System.out.println("\n________________________________\n");

        // Test Case 3: Insufficient Balance Error
        System.out.println("TEST CASE 3: Insufficient Balance Error");
        Customer poorCustomer = new Customer("Poor Customer", 100);
        Cart expensiveCart = new Cart();
        expensiveCart.addProduct(tv, 1);
        CheckoutService.checkout(poorCustomer, expensiveCart);
        System.out.println("\n________________________________\n");

        // Test Case 4: Expired Product Error
        System.out.println("TEST CASE 4: Expired Product Error");
        Cheese expiredCheese = new Cheese("Expired Cheese", 100, 5, 0.4, true);
        Customer customer3 = new Customer("Test Customer", 1000);
        Cart expiredCart = new Cart();
        expiredCart.addProduct(expiredCheese, 1);
        CheckoutService.checkout(customer3, expiredCart);
        System.out.println("\n________________________________\n");

        // Test Case 5: Out of Stock Error
        System.out.println("TEST CASE 5: Out of Stock Error");
        Cheese lowStockCheese = new Cheese("Low Stock Cheese", 100, 1, 0.4, false);
        Customer customer4 = new Customer("Stock Test Customer", 1000);
        Cart stockCart = new Cart();
        stockCart.addProduct(lowStockCheese, 2);
        CheckoutService.checkout(customer4, stockCart);
        System.out.println("\n________________________________\n");

        // Test Case 6: Mixed Products (Shippable and Non-Shippable)
        System.out.println("TEST CASE 6: Mixed Products (Shippable and Non-Shippable)");
        Customer customer5 = new Customer("Mixed Customer", 10000);
        Cart mixedCart = new Cart();
        mixedCart.addProduct(cheese, 2); // Shippable, expirable
        mixedCart.addProduct(biscuits, 1); // Shippable, expirable
        mixedCart.addProduct(mobile, 1); // Non-shippable, non-expirable
        mixedCart.addProduct(scratchCard, 3); // Non-shippable, non-expirable
        CheckoutService.checkout(customer5, mixedCart);
        System.out.println("\n________________________________\n");

        System.out.println("Test Done, I hope to join this internship");
    }
}