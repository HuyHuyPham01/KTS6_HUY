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

import com.example.kiemtra_nhathuy.adapter.SanPhamAdapter;
import com.example.kiemtra_nhathuy.model.Contact;
import com.example.kiemtra_nhathuy.model.SanPham;

public class MainActivity_KT4 extends AppCompatActivity {
    ListView listView_NangCao;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ListView Nâng Cao");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView_NangCao = findViewById(R.id.listView_NangCao);
        sanPhamAdapter = new SanPhamAdapter(MainActivity_KT4.this,R.layout.item_kt4);
        listView_NangCao.setAdapter(sanPhamAdapter);

        listView_NangCao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamAdapter.getItem(i);
                Toast.makeText(MainActivity_KT4.this, "Bạn chọn: Sản Phẩm " + sp.getTen(), Toast.LENGTH_SHORT).show();
            }
        });

        listView_NangCao.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham c = sanPhamAdapter.getItem(position);

                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity_KT4.this);

                //Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý xoá không?");

                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sanPhamAdapter.remove(c);
                        Toast.makeText(MainActivity_KT4.this,"Deleted",Toast.LENGTH_SHORT).show();
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
                return false;
            }
        });

        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_1,"1",60));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_2,"2",70));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_3,"3",75));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_4,"4",80));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_5,"5",50));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_6,"6",40));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_7,"7",20));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_8,"8",10));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_9,"9",65));
        sanPhamAdapter.add(new SanPham(R.drawable.img_kt4_10,"10",25));

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
                Toast.makeText(MainActivity_KT4.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuInfo:
                Intent i = new Intent(MainActivity_KT4.this,MainActivity_Menu_Info.class);
                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity_KT4.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
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