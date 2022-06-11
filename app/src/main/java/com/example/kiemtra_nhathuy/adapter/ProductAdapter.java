package com.example.kiemtra_nhathuy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kiemtra_nhathuy.R;
import com.example.kiemtra_nhathuy.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity activity;

    public ProductAdapter(Activity activity, ArrayList products) {
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

        Product product = getItem(position);
        textViewTenSP.setText(product.getTenSp());
        textViewDonVi.setText(product.getDonVi());
        String s = (new DecimalFormat("#,###.##")).format(product.getGiaSp());
        textViewGiaSP.setText(s);
        return convertView;
    }
}
