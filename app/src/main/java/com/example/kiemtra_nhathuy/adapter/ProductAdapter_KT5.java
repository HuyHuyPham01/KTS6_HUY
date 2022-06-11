package com.example.kiemtra_nhathuy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kiemtra_nhathuy.R;
import com.example.kiemtra_nhathuy.model.Product_KT5;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter_KT5 extends ArrayAdapter<Product_KT5> {
    Activity activity;

    public ProductAdapter_KT5(Activity activity, ArrayList products) {
        super(activity,0, products);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_kt5,null);
        }

        TextView textViewTenSP = convertView.findViewById(R.id.textViewTenSP);
        TextView textViewDonVi = convertView.findViewById(R.id.textViewDonVi);
        TextView textViewGiaSP = convertView.findViewById(R.id.textViewGiaSP);

        Product_KT5 productKT5 = getItem(position);
        textViewTenSP.setText(productKT5.getTenSp());
        textViewDonVi.setText(productKT5.getDonVi());
        String s = (new DecimalFormat("#,###.##")).format(productKT5.getGiaSp());
        textViewGiaSP.setText(s);
        return convertView;
    }
}
