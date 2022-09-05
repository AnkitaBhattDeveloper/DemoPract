package com.example.kiki.data;

public class CartItemModel {

    String item_url,item_name,item_desc,item_price;
    int item_count=0;

     int sum = 0;

    public int getSum() {
        return sum;
    }

    public int setSum(int sum) {
        this.sum = sum;
        return sum;
    }

    public int getItem_count() {
        if (item_count<0)
            return 0;

        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
   }

    public CartItemModel(String item_url, String item_name, String item_desc, String item_price)
    {
        this.item_url = item_url;
        this.item_name = item_name;
        this.item_desc = item_desc;
        this.item_price = item_price;
    }

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }
}
