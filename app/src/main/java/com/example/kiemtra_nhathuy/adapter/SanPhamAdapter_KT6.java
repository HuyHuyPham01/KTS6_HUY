package com.example.kiemtra_nhathuy.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kiemtra_nhathuy.R;
import com.example.kiemtra_nhathuy.model.SanPham_KT6;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamAdapter_KT6 extends ArrayAdapter<SanPham_KT6> {
    Activity activity;

    public SanPhamAdapter_KT6(Activity activity, ArrayList sanphams) {
        super(activity,0, sanphams);
        this.activity = activity;
    }
    @NonNull
    @Override
    public View getView(int position, View customView, ViewGroup viewGroup) {
        if(customView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            customView = inflater.inflate(R.layout.item_kt6,null);
        }

        ImageView imageViewHinh = customView.findViewById(R.id.imageViewHinh);
        TextView textViewTen = customView.findViewById(R.id.textViewTen);
        TextView textViewGia = customView.findViewById(R.id.textViewGia);

        SanPham_KT6 sanPham_kt6 = getItem(position);
        int imageId = this.getMipmapResIdByName(sanPham_kt6.getHinh());

        imageViewHinh.setImageResource(imageId);
        textViewTen.setText(sanPham_kt6.getTen());
        String s = (new DecimalFormat("#,###.##")).format(sanPham_kt6.getGia());
        textViewGia.setText("Giá: "+s);

        return customView;
    }

    public int getMipmapResIdByName(String resName)  {
        String pkgName = activity.getPackageName();
        // Return 0 if not found.
        int resID = activity.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
}
