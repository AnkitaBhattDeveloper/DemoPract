package com.example.kiki.data;

public class ItemListModel{
    String item_image,Item_name,item_description,item_price;

    public ItemListModel()
    {

    }

    public ItemListModel(String item_image, String item_name, String item_description, String item_price) {
        this.item_image = item_image;
        Item_name = item_name;
        this.item_description = item_description;
        this.item_price = item_price;
    }

    public String getItem_image() {
        return item_image;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
    }

    public String getItem_name() {
        return Item_name;
    }

    public void setItem_name(String item_name) {
        Item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }
}
