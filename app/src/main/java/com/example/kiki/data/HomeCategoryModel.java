package com.example.kiki.data;

public class HomeCategoryModel {
    String cat_name;
        String cat_image;

    public HomeCategoryModel(String image,String name)
    {
        this.cat_image = image;
        this.cat_name = name;
    }


    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_image() {
        return cat_image;
    }

    public void setCat_image(String cat_image) {
        this.cat_image = cat_image;
    }
}
