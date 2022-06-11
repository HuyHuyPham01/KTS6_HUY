package com.example.kiemtra_nhathuy.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kiemtra_nhathuy.R;
import com.example.kiemtra_nhathuy.model.SanPham;

import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;

    public SanPhamAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        ImageView imageViewHinh = customView.findViewById(R.id.imageViewHinh);
        TextView textViewTen = customView.findViewById(R.id.textViewTen);
        TextView textViewGia = customView.findViewById(R.id.textViewGia);

        SanPham sp = getItem(position);
        imageViewHinh.setImageResource(sp.getHinh());
        textViewTen.setText("Sản phẩm "+ sp.getTen());
        textViewGia.setText(sp.getGia()+" 000 VNĐ");

        return customView;
    }
}
