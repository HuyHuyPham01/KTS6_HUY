package com.example.kiemtra_nhathuy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kiemtra_nhathuy.adapter.SanPhamAdapter_KT6;
import com.example.kiemtra_nhathuy.model.SanPhamManager_KT6;
import com.example.kiemtra_nhathuy.model.SanPham_KT6;

import java.util.ArrayList;

public class MainActivity_KT6 extends AppCompatActivity {
    ListView listView_NangCao;
    SanPhamAdapter_KT6 sanPhamAdapter_kt6;
    Intent i;
    EditText editTextTenSP,editTextHinhAnh,editTextGiaSP;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt6);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Bài kiểm tra số 6");
        actionBar.setDisplayHomeAsUpEnabled(true);

        buttonAdd = findViewById(R.id.buttonAdd);
        editTextTenSP = findViewById(R.id.editTextTenSP);
        editTextHinhAnh = findViewById(R.id.editTextHinhAnh);
        editTextGiaSP = findViewById(R.id.editTextGiaSP);
        listView_NangCao = findViewById(R.id.listView_NangCao);

        // Khởi tạo các sản phẩm
        SanPhamManager_KT6 sanPhamManagerKT6 = SanPhamManager_KT6.get();
        sanPhamManagerKT6.generateSanPhams();

        // Lấy các productKT5 từ class saleManager
        ArrayList sanphams = sanPhamManagerKT6.getSanPhams();
        // Khởi tạo adapter
        sanPhamAdapter_kt6 = new SanPhamAdapter_KT6(MainActivity_KT6.this, sanphams);
        // Hiển thị lên listview
        listView_NangCao.setAdapter(sanPhamAdapter_kt6);

        // Thêm sản phẩm
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyCustom();
            }
        });

        listView_NangCao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity_KT6.this, MainActivity_Add_Edit_KT6.class);
                intent.putExtra(MainActivity_Add_Edit_KT6.EXTRA_POSITION, position);
                startActivity(intent);
            }
        });

        listView_NangCao.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham_KT6 c = sanPhamAdapter_kt6.getItem(position);

                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity_KT6.this);

                //Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý xoá không?");

                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sanPhamAdapter_kt6.remove(c);
                        Toast.makeText(MainActivity_KT6.this,"Deleted",Toast.LENGTH_SHORT).show();
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
                return true;
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
                Toast.makeText(MainActivity_KT6.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuInfo:
                Intent i = new Intent(MainActivity_KT6.this,MainActivity_Menu_Info.class);
                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity_KT6.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuThoat:
                XuLyThoat();
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openMyCustom() {
        // Khởi tạo AlertDialog từ đối tượng Builder. tham số truyền vào ở đây là context.
        final AlertDialog builder = new AlertDialog.Builder(this).create();

        // Khởi tạo đối tượng View từ file activity_add_edit_kt5.
        final View alert = LayoutInflater.from(this).inflate(R.layout.activity_add_edit_kt6, null);

        // Set layout cho alert dialog
        builder.setView(alert);

        final EditText editTextTenSP;
        final EditText editTextHinhAnh;
        final EditText editTextGiaSP;
        Button buttonLuu;
        Button buttonThoat;

        // Tham chiếu các đối tượng có trên giao diện dialog vừa được set
        editTextTenSP = alert.findViewById(R.id.editTextTenSP);
        editTextHinhAnh = alert.findViewById(R.id.editTextHinhAnh);
        editTextGiaSP = alert.findViewById(R.id.editTextGiaSP);
        buttonLuu = alert.findViewById(R.id.buttonLuu);
        buttonThoat = alert.findViewById(R.id.buttonThoat);

        // Tạo dialog và hiển thị
        builder.show();

        // Bắt sự kiện click vào nút Lưu
        buttonLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham_KT6 sanPham_kt6 = new SanPham_KT6();
                sanPham_kt6.setTen(editTextTenSP.getText().toString());
                sanPham_kt6.setHinh(editTextHinhAnh.getText().toString());
                String s = editTextGiaSP.getText().toString();
                s = s.replace(",", "");
                double price = Double.parseDouble(s);
                sanPham_kt6.setGia(price);
                sanPhamAdapter_kt6.add(sanPham_kt6);
                sanPhamAdapter_kt6.notifyDataSetChanged();
                builder.dismiss();
            }
        });

        // Bắt sự kiện click vào nút Thoát
        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
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
}