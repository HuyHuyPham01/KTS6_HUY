package com.example.kiemtra_nhathuy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kiemtra_nhathuy.model.SanPhamManager_KT6;
import com.example.kiemtra_nhathuy.model.SanPham_KT6;

import java.text.DecimalFormat;

public class MainActivity_Add_Edit_KT6 extends AppCompatActivity {
    public static final String EXTRA_POSITION = "position";
    Button buttonLuu,buttonThoat;
    EditText editTextTenSP,editTextHinhAnh,editTextGiaSP;
    SanPham_KT6 sanPham_kt6;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_kt6);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Chỉnh sửa sản phẩm");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Lấy các control trên layout
        buttonLuu = findViewById(R.id.buttonLuu);
        buttonThoat = findViewById(R.id.buttonThoat);
        editTextTenSP = findViewById(R.id.editTextTenSP);
        editTextHinhAnh = findViewById(R.id.editTextHinhAnh);
        editTextGiaSP = findViewById(R.id.editTextGiaSP);

        // Hiển thị lên màn hình
        Intent it = getIntent();
        position = it.getExtras().getInt(EXTRA_POSITION);

        if (position != -1) {
            sanPham_kt6 = (SanPham_KT6) SanPhamManager_KT6.get().getSanPhams().get(position);
            editTextTenSP.setText(sanPham_kt6.getTen());
            editTextHinhAnh.setText(sanPham_kt6.getHinh());
            String s = (new DecimalFormat("#,###.##")).format(sanPham_kt6.getGia());
            editTextGiaSP.setText(s);
        }

        if(position == -1) {
            sanPham_kt6 = new SanPham_KT6();
            Log.d("position", "-1");
        }

        // Thiết đặt sự kiện khi click vào các button
        buttonLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu từ layout để cập nhật lại các sản phẩm trong mảng
                sanPham_kt6.setTen(editTextTenSP.getText().toString());
                sanPham_kt6.setHinh(editTextHinhAnh.getText().toString());
                String s = editTextGiaSP.getText().toString();
                s = s.replace(",", "");
                double price = Double.parseDouble(s);
                sanPham_kt6.setGia(price);
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Không làm gì cả và trở về màn hình trước
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
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
                Toast.makeText(MainActivity_Add_Edit_KT6.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuInfo:
                Intent i = new Intent(MainActivity_Add_Edit_KT6.this,MainActivity_Menu_Info.class);
                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity_Add_Edit_KT6.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuThoat:
                XuLyThoat();
            default:break;
        }

        return super.onOptionsItemSelected(item);
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
}