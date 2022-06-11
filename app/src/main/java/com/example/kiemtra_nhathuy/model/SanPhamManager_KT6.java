package com.example.kiemtra_nhathuy.model;

import java.util.ArrayList;

public class SanPhamManager_KT6 {

    private ArrayList SanPhams;

    public SanPhamManager_KT6() {
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

    private static SanPhamManager_KT6 sanPhamManagerKT6;

    public static SanPhamManager_KT6 get() {
        if (sanPhamManagerKT6 == null)
            sanPhamManagerKT6 = new SanPhamManager_KT6();
        return sanPhamManagerKT6;
    }
}
