package com.example.kiemtra_nhathuy.model;

public class Contact_KT3 {
    int id;
    String name;
    String phone;

    public Contact_KT3() {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){
        return "ID: " + this.id + " - Name: " + this.name + "\nPhone Number: " + this.phone;
    }
}
