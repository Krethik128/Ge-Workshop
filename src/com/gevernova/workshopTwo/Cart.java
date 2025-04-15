package com.gevernova.workshopTwo;

public class Cart {
    public String name;
//    private List<Product> products;
    private  Product arr[];
    private int orderNumber=0;
    private final int maxsize=10;

    public Cart(String n) {
        name = n;
//        this.products=new ArrayList<>();
        this.arr=new Product[maxsize];
    }

    public void addProducts(Product productDetails){
        if (orderNumber >= maxsize) {
            System.out.println("Cart is full");
            return;
        }
        if(orderNumber<9){
            boolean present=false;
            for (int i = 0; i < orderNumber; i++) {
                if (productDetails.equals(arr[i])) {
                    int quant = arr[i].getQuantity();
                    arr[i].setQuantity(quant + 1);
                    present = true;
                    break;
                }
            }

            if (!present) {
                arr[orderNumber] = productDetails;
                orderNumber++;
            }

        }
    }
    public void displayProducts(){
        /*for(Product p:products){
            System.out.println(this.name +" Product name- "+p.getName()+" of $"+p.getPrice());
        }*/
        for (int i = 0; i < orderNumber; i++) {
            if (arr[i] != null) {
                System.out.println(name + " - Product: " + arr[i].getName() + ", Quantity: " + arr[i].getQuantity() + ", Total: $" + (arr[i].getPrice() * arr[i].getQuantity()));
            }
        }
    }
    public void totalCost(){
        int sum=0;
        for(int i=0;i<orderNumber;i++){
            if(arr[i]!=null) {
                sum += arr[i].getPrice()*arr[i].getQuantity();
            }
        }
        System.out.println("Total cost of all products in " + name + " is: $" + sum);
    }
    public void removeProduct(Product product){
        for(int i=0;i<orderNumber-1;i++){
            if(product.equals(arr[i])){
                for(int j=i+1;j<orderNumber;j++) {
                    arr[j - 1] = arr[j];
                }
                arr[orderNumber - 1] = null;
                orderNumber--;
                System.out.println(product.getName() + " removed from cart.");
                return;
            }
        }
        System.out.println(product.getName() + " not found in cart.");
    }

    public String getName() {
        return name;
    }
}
