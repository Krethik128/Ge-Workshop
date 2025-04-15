package com.gevernova.workshopTwo;

//Create classes Product, Cart, and Customer.
//Let a customer add/remove products from a cart and calculate the total price.
public class Customer {
    private String name;
//    public List<Cart> cart;
    public Cart arr[];
    private int idx=0;

    public Customer(String name) {
        this.name = name;
//        this.cart = new ArrayList<>();
        this.arr=new Cart[10];
    }
    public void addCartname(Cart cart){
//        cart.add(name);
        if(idx<10){
            arr[idx++]=cart;
        }
        else{
            System.out.println("Cannot add more carts. Maximum limit reached.");
        }
    }

    public void displayAllcarts(){
        for(int i=0;i<idx;i++){
            System.out.println(arr[i].getName());
        }
    }

}

