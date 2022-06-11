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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_KT2 extends AppCompatActivity {
    EditText editTextDL;
    Button buttonChuyenDoi;
    TextView textViewAmLich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Bài kiểm tra số 2");
        actionBar.setDisplayHomeAsUpEnabled(true);

        editTextDL = findViewById(R.id.editTextDL);
        buttonChuyenDoi = findViewById(R.id.buttonChuyenDoi);
        textViewAmLich = findViewById(R.id.textViewAmLich);

        buttonChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Can[] = {"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bỉnh","Đinh","Mậu","Kỷ"};
                String Chi[]={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};

                String nam = editTextDL.getText().toString();
                if (nam.isEmpty()) {
                    Toast.makeText(MainActivity_KT2.this, "Vui lòng nhập Năm Dương Lịch", Toast.LENGTH_LONG).show();
                }
                else {
                    int namDuong = Integer.parseInt(nam);
                    String namAm = Can[namDuong%10] + " " + Chi[namDuong%12];
                    textViewAmLich.setText(namAm);
                }
            }
        });

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//            default:break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

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
                Toast.makeText(MainActivity_KT2.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuInfo:
                Intent i = new Intent(MainActivity_KT2.this,MainActivity_Menu_Info.class);
                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity_KT2.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
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