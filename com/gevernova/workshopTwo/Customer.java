package com.gevernova.workshopTwo;

//Create classes Product, Cart, and Customer.
//Let a customer add/remove products from a cart and calculate the total price.
public class Customer implements Displayable {
    private final String name;
    public Cart[] carts;
    private int cartCount;
    private static final int MAX_CARTS = 10;

    public Customer(String name) {
        this.name = name;
        this.carts=new Cart[MAX_CARTS];
    }
    public void addCart(Cart cart){
        if(cartCount<MAX_CARTS){
            carts[cartCount++]=cart;
        }
        else{
            System.out.println("Cannot add more carts. Maximum limit reached.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("\nCustomer: " + name);
        for (int i = 0; i < cartCount; i++) {
            carts[i].displayDetails();
        }
    }

}

