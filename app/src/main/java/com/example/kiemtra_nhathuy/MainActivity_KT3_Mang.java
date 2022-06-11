package com.example.kiemtra_nhathuy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity_KT3_Mang extends AppCompatActivity {
    ListView listView_Mang;
    String [] stringData = {"Lê Huế Anh",
            "Đỗ Gia Bảo",
            "Nguyễn Chí Cường",
            "Đặng Thụy Thanh Duy",
            "Lê Thanh Huy",
            "Phạm Huỳnh Nhật Huy",
            "Trượng Lệ Hào",
            "Đinh Nguyễn Trường Hải",
            "Đặng Anh Kiệt",
            "Lê Đức Lợi",
            "Huỳnh Hữu Lý",
            "Huỳnh Đức Lộc",
            "Chế Phương Nam",
            "Trần Hiếu Nghĩa",
            "Minh Nhựt Nguyễn Thanh",
            "Trần Đức Nhân",
            "Lê Phú Phúc",
            "Trần Minh Quang",
            "Nguyễn Trường Quý",
            "Bùi Minh Thiên",
            "Nguyễn Thị Bảo Trân",
            "Nguyễn Xuân Trường",
            "Nguyễn Văn Trung Trực",
            "Nguyễn Trần Quang Tuyến",
            "Nguyễn Thị Thanh Tuyền",
            "Nguyễn Huỳnh Trung Tính",
            "Đoàn Tường Vy",
            "Huỳnh Thành Đạt",
            "Nguyễn Tấn Đạt",
            "Phạm Minh Đức" };
    ArrayAdapter<String> adapterString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt3_mang);

        listView_Mang = findViewById(R.id.listView_Mang);

        adapterString = new ArrayAdapter<String>(MainActivity_KT3_Mang.this, android.R.layout.simple_list_item_1, stringData);
        listView_Mang.setAdapter(adapterString);

        listView_Mang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity_KT3_Mang.this, "Bạn chọn: " + stringData[i], Toast.LENGTH_SHORT).show();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Danh Sách Lớp CĐ ĐTTT 19MT");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}