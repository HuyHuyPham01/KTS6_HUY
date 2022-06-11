package com.example.kiemtra_nhathuy.model;

import java.util.ArrayList;

public class SaleManager {
    private ArrayList Products;

    public SaleManager() {
        Products = new ArrayList();
    }

    public ArrayList getProducts() {
        return Products;
    }

    public void setProducts(ArrayList products) {
        Products = products;
    }

    public void generateProducts() {
        Products.clear();
        Products.add(new Product("Iphone 13 Pro Max 1TB", "Cái", 44890000));
        Products.add(new Product("Apple Watch Series 7 LTE", "Cái", 18261000));
        Products.add(new Product("Bánh mì", "Ổ", 20000));
        Products.add(new Product("Xôi", "Gói", 20000));
        Products.add(new Product("Trà sữa", "Ly", 30000));
    }

    private static SaleManager saleManager;

    public static SaleManager get() {
        if (saleManager == null)
            saleManager = new SaleManager();
        return saleManager;
    }
}
