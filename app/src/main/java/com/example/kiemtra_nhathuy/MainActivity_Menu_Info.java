package com.example.kiemtra_nhathuy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_Menu_Info extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thông tin sinh viên");
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://facebook.com/HuyHuyPham01";
                AlertDialog.Builder d = new AlertDialog.Builder(MainActivity_Menu_Info.this);

                // Thiết lập tiêu đề
                d.setTitle("Xác nhận");
                d.setMessage("Bạn có đồng ý truy cập Facebook không?");

                // Nút OK
                d.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                        startActivity(intent);

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);

//                        Intent startMain = new Intent(Intent.ACTION_MAIN);
//                        startActivity(startMain);
                        finish();
                    }
                });

                // Nút Cancel
                d.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                // Tạo dialog
                AlertDialog al = d.create();

                // Hiển thị
                al.show();
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
                Toast.makeText(MainActivity_Menu_Info.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuInfo:
//                Intent i = new Intent(MainActivity_Menu_Info.this,MainActivity_Menu_Info.class);
//                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity_Menu_Info.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuThoat:
                XuLyThoat();
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void XuLyThoat() {
        // Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);

        // Thiết lập tiêu đề
        b.setTitle("Xác nhận");
        b.setMessage("Bạn có đồng ý thoát chương trình không?");

        // Nút OK
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startActivity(startMain);
                finish();
            }
        });

        // Nút Cancel
        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        // Tạo dialog
        AlertDialog al = b.create();

        // Hiển thị
        al.show();
    }
}