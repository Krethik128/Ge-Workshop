package com.gevernova.workshopTwo;

public class Main {
    public static void main(String[] args) {
        Customer krethik = new Customer("Krethik");
        Cart order1 = new Cart("Order1");
        Cart order2 = new Cart("Order2");

        krethik.addCart(order1);
        krethik.addCart(order2);

        Product product1 = new Product("Cycle", 2000);
        Product product2 = new Product("Bike", 45000);
        Product product3 = new Product("Shoes", 50);
        Product product4 = new Product("Shirt", 25);
   ;     Product product5 = new Product("Scooty", 32000);


        // Add products to Order1
        order1.addProducts(product1);
        order1.addProducts(product2);
        order1.addProducts(product5);
        order1.addProducts(product5);

        order2.addProducts(product3);
        order2.addProducts(product4);

        order1.displayDetails();
        order1.removeProduct(product1);
        order1.displayDetails();

        order2.displayDetails();

        System.out.println("\nDisplay all carts for Krethik:");
        krethik.displayDetails();
    }
}