package com.gevernova.workshopTwo;

public class Main {
    public static void main(String[] args) {
        Customer krethik = new Customer("Krethik");
        Cart order1 = new Cart("Order1");
        Cart order2 = new Cart("Order2");

        krethik.addCartname(order1);
        krethik.addCartname(order2);

        Product product1 = new Product("Cycle", 2000);
        Product product2 = new Product("Bike", 45000);
        Product product6 = new Product("Scooty", 32000);
        Product product7 = product6; // Same as product6 (object reference)

        Product product3 = new Product("Shoes", 50);
        Product product4 = new Product("Shirt", 25);

        // Add products to Order1
        order1.addProducts(product1);
        order1.addProducts(product2);
        order1.addProducts(product6);
        order1.displayProducts();
        order1.addProducts(product7); // Increases quantity of Scooty

        // Add products to Order2
        order2.addProducts(product3);
        order2.addProducts(product4);

        // Display Order1 details
        order1.displayProducts();
        order1.totalCost();

        // Remove product from Order1
        order1.removeProduct(product1);
        order1.displayProducts();
        order1.totalCost();

        // Display Order2 details
        order2.displayProducts();
        order2.totalCost();

        // Display all carts for the customer
        System.out.println("\nDisplay all carts details");
        krethik.displayAllcarts();
    }
}