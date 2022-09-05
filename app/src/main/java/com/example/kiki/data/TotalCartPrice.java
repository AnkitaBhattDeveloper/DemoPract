package com.example.kiki.data;

public class TotalCartPrice {
    String productName;
    int productPrice;

    public TotalCartPrice()
    {

    }

     public  TotalCartPrice(String productName,int productPrice)
     {
         this.productName = productName;
         this.productPrice = productPrice;

     }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
