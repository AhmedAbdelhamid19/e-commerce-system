package com.fawry.ecommerce;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        if (amount > balance) {
            System.out.println("Error: Insufficient balance");
            return;
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", Balance: " + balance;
    }
} 