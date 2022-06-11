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
import android.widget.Button;
import android.widget.Toast;

public class MainActivity_KT3 extends AppCompatActivity {
    Button buttonLVCB_Mang,buttonLVCB_String_Array,buttonLVCB_Object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt3);

        buttonLVCB_Mang = findViewById(R.id.buttonLVCB_Mang);
        buttonLVCB_String_Array = findViewById(R.id.buttonLVCB_String_Array);
        buttonLVCB_Object = findViewById(R.id.buttonLVCB_Object);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ListView Cơ Bản");
        actionBar.setDisplayHomeAsUpEnabled(true);

        buttonLVCB_Mang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_KT3.this, MainActivity_KT3_Mang.class);
                startActivity(i);
            }
        });

        buttonLVCB_String_Array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_KT3.this, MainActivity_KT3_String_Array.class);
                startActivity(i);
            }
        });

        buttonLVCB_Object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_KT3.this, MainActivity_KT3_Object.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                Toast.makeText(MainActivity_KT3.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuInfo:
                Intent i = new Intent(MainActivity_KT3.this,MainActivity_Menu_Info.class);
                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity_KT3.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuThoat:
                XuLyThoat();
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void XuLyThoat() {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);

        //Thiết lập tiêu đề
        b.setTitle("Xác nhận");
        b.setMessage("Bạn có đồng ý thoát chương trình không?");

        // Nút Ok
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startActivity(startMain);
                finish();
            }
        });

        //Nút Cancel
        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        //Tạo dialog
        AlertDialog al = b.create();

        //Hiển thị
        al.show();
    }
}