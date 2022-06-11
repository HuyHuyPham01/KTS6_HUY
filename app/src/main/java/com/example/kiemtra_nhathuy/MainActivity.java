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
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    Button buttonThoat;
    ImageView imageViewKT1,imageViewKT2,imageViewKT3,imageViewKT4,imageViewKT5,imageViewKT6;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Phạm Huỳnh Nhật Huy");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

//        buttonThoat = findViewById(R.id.buttonThoat);
        imageViewKT1 = findViewById(R.id.imageViewKT1);
        imageViewKT2 = findViewById(R.id.imageViewKT2);
        imageViewKT3 = findViewById(R.id.imageViewKT3);
        imageViewKT4 = findViewById(R.id.imageViewKT4);
        imageViewKT5 = findViewById(R.id.imageViewKT5);
        imageViewKT6 = findViewById(R.id.imageViewKT6);

//        buttonThoat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                XuLyThoat();
//            }
//        });

        imageViewKT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this,MainActivity_KT1.class);
                startActivity(i);
            }
        });

        imageViewKT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this,MainActivity_KT2.class);
                startActivity(i);
            }
        });

        imageViewKT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, MainActivity_KT3.class);
                startActivity(i);
            }
        });

        imageViewKT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, MainActivity_KT4.class);
                startActivity(i);
            }
        });

        imageViewKT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, MainActivity_KT5.class);
                startActivity(i);
            }
        });

        imageViewKT6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, MainActivity_KT6.class);
                startActivity(i);
            }
        });
    }

    private void XuLyThoat() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);

        b.setTitle("Xác nhận");
        b.setMessage("Bạn có đồng ý thoát chương trình không?");

        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startActivity(startMain);
                finish();
            }
        });

        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog al = b.create();

        al.show();
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
                Toast.makeText(MainActivity.this, "Bạn nhấn vào Menu", Toast.LENGTH_SHORT).show();
                break;
//                onBackPressed();
//                return true;
            case R.id.menu1:
                Toast.makeText(MainActivity.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuInfo:
                Intent i = new Intent(MainActivity.this,MainActivity_Menu_Info.class);
                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuThoat:
                XuLyThoat();
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

}