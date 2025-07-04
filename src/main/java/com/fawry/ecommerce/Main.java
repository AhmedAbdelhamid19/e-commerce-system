package com.fawry.ecommerce;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Cheese cheese = new Cheese("Cheese", 100, 10, 0.4, false);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, 0.7, false);
        TV tv = new TV("TV", 5000, 3, 10.0);
        Mobile mobile = new Mobile("Mobile", 3000, 8);
        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 20);

        System.out.println("--- Product Test ---");
        System.out.println(cheese.getName() + ": price=" + cheese.getPrice() + ", qty=" + cheese.getQuantity() + ", weight=" + cheese.getWeight() + ", expired=" + cheese.isExpired());
        System.out.println(biscuits.getName() + ": price=" + biscuits.getPrice() + ", qty=" + biscuits.getQuantity() + ", weight=" + biscuits.getWeight() + ", expired=" + biscuits.isExpired());
        System.out.println(tv.getName() + ": price=" + tv.getPrice() + ", qty=" + tv.getQuantity() + ", weight=" + tv.getWeight());
        System.out.println(mobile.getName() + ": price=" + mobile.getPrice() + ", qty=" + mobile.getQuantity());
        System.out.println(scratchCard.getName() + ": price=" + scratchCard.getPrice() + ", qty=" + scratchCard.getQuantity());
    }
}