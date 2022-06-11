package com.example.kiemtra_nhathuy.model;

public class Product_KT5 {
    String tenSp;
    String donVi;
    double giaSp;

    public Product_KT5(){
        tenSp = "";
        donVi = "";
        giaSp = 0;
    }


    public Product_KT5(String tenSp, String donVi, double giaSp) {
        this.tenSp = tenSp;
        this.donVi = donVi;
        this.giaSp = giaSp;
    }


    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(double giaSp) {
        this.giaSp = giaSp;
    }


}
