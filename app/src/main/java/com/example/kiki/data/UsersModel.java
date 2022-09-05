package com.example.kiki.data;

public class UsersModel {

    String id,name,email,address,phone_no;

    public UsersModel(String id,String name,String email,String address,String phone_no) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
