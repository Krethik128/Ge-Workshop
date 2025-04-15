package com.gevernova.workshopTwo;

//Create classes Product, Cart, and Customer.
//Let a customer add/remove products from a cart and calculate the total price.
public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name,int price) {
        this.name = name;
        this.price=price;
        this.quantity=1;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
