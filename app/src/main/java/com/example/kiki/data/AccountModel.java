package com.example.kiki.data;

public class AccountModel {
    String name,mobile_number;


    public AccountModel(){}


    public AccountModel(String name, String mobile_number)
    {
        this.name= name;
        this.mobile_number = mobile_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}
