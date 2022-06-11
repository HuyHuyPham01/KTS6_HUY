package com.example.kiemtra_nhathuy.model;

public class SanPham {
    int Hinh;
    String Ten;
    int Gia;

    public SanPham(int hinh, String ten, int gia) {
        Hinh = hinh;
        Ten = ten;
        Gia = gia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }
}
