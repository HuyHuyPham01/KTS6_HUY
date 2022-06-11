package com.example.kiemtra_nhathuy.model;

public class SanPham_KT6 {
    String Hinh;
    String Ten;
    double Gia;

    public SanPham_KT6(String hinh, String ten, double gia) {
        Hinh = hinh;
        Ten = ten;
        Gia = gia;
    }

    public SanPham_KT6() {

    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }
}
