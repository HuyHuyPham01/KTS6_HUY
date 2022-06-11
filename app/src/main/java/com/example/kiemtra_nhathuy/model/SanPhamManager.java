package com.example.kiemtra_nhathuy.model;

import java.util.ArrayList;

public class SanPhamManager {

    private ArrayList SanPhams;

    public SanPhamManager() {
        SanPhams = new ArrayList();
    }

    public ArrayList getSanPhams() {
        return SanPhams;
    }

    public void setSanPhams(ArrayList sanPhams) {
        SanPhams = sanPhams;
    }

    public void generateSanPhams() {
        SanPhams.clear();
        SanPhams.add(new SanPham_KT6("huy", "Huy Huy Phạm \n(Flash Sale - Freeship)", 0));
        SanPhams.add(new SanPham_KT6("image2", "Sản phẩm 2", 100000));
        SanPhams.add(new SanPham_KT6("image3", "Sản phẩm 3", 150000));
    }

    private static SanPhamManager sanPhamManager;

    public static SanPhamManager get() {
        if (sanPhamManager == null)
            sanPhamManager = new SanPhamManager();
        return sanPhamManager;
    }
}
