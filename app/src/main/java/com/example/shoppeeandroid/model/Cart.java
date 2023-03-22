package com.example.shoppeeandroid.model;

import java.io.Serializable;

public class Cart implements Serializable {
   private String product;
   private String seller;
   private int price;
 private    int quantity;

    public Cart( String product, String seller, int price, int quantity){
        this.product= product;
        this.seller=seller;
        this.price = price;
        this.quantity= quantity;
    }
    public Cart(){

    }
    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getProduct (){
        return product;
    }
    public void setProduct(String product){
        this.product=product;
    }
    public String getSeller(){
        return seller;
    }


}
