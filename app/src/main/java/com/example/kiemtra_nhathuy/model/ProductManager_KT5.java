package com.example.kiemtra_nhathuy.model;

import java.util.ArrayList;

public class ProductManager_KT5 {
    private ArrayList Products;

    public ProductManager_KT5() {
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
        Products.add(new Product_KT5("Iphone 13 Pro Max 1TB", "Cái", 44890000));
        Products.add(new Product_KT5("Apple Watch Series 7 LTE", "Cái", 18261000));
        Products.add(new Product_KT5("Bánh mì", "Ổ", 20000));
        Products.add(new Product_KT5("Xôi", "Gói", 20000));
        Products.add(new Product_KT5("Trà sữa", "Ly", 30000));
    }

    private static ProductManager_KT5 productManagerKT5;

    public static ProductManager_KT5 get() {
        if (productManagerKT5 == null)
            productManagerKT5 = new ProductManager_KT5();
        return productManagerKT5;
    }
}
