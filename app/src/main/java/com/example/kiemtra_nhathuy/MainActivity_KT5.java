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

import com.example.kiemtra_nhathuy.adapter.ProductAdapter_KT5;
import com.example.kiemtra_nhathuy.model.Product_KT5;
import com.example.kiemtra_nhathuy.model.ProductManager_KT5;

import java.util.ArrayList;

public class MainActivity_KT5 extends AppCompatActivity {
    ListView listViewShop;
    ProductAdapter_KT5 productAdapterKT5;
    Button buttonAdd;
    Intent i;
    EditText editTextTenSP,editTextDonVi,editTextGiaSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt5);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Bài kiểm tra số 5");
        actionBar.setDisplayHomeAsUpEnabled(true);

        buttonAdd = findViewById(R.id.buttonAdd);
        editTextTenSP = findViewById(R.id.editTextTenSP);
        editTextDonVi = findViewById(R.id.editTextDonVi);
        editTextGiaSP = findViewById(R.id.editTextGiaSP);
        listViewShop = findViewById(R.id.listViewShop);

        // Khởi tạo các sản phẩm
        ProductManager_KT5 productManagerKT5 = ProductManager_KT5.get();
        productManagerKT5.generateProducts();

        // Lấy các productKT5 từ class productManagerKT5
        ArrayList products = productManagerKT5.getProducts();
        // Khởi tạo adapter
        productAdapterKT5 = new ProductAdapter_KT5(MainActivity_KT5.this, products);
        // Hiển thị lên listview
        listViewShop.setAdapter(productAdapterKT5);

        // Thêm sản phẩm
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyCustom();
            }
        });

        // Click để sửa
        listViewShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity_KT5.this, MainActivity_Add_Edit_KT5.class);
                intent.putExtra(MainActivity_Add_Edit_KT5.EXTRA_POSITION, position);
                startActivity(intent);
            }
        });

        // Long click để xoá
        listViewShop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Product_KT5 c = productAdapterKT5.getItem(position);

                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity_KT5.this);

                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý xoá không?");

                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        productAdapterKT5.remove(c);
                        Toast.makeText(MainActivity_KT5.this,"Deleted",Toast.LENGTH_SHORT).show();
                    }
                });

                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog al = b.create();

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
                Toast.makeText(MainActivity_KT5.this, "Bạn nhấn vào Bảng điểm", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuInfo:
                Intent i = new Intent(MainActivity_KT5.this,MainActivity_Menu_Info.class);
                startActivity(i);
                break;
            case R.id.menuBaiTap:
                Toast.makeText(MainActivity_KT5.this, "Bạn nhấn vào Bài tập", Toast.LENGTH_SHORT).show();
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
        final View alert = LayoutInflater.from(this).inflate(R.layout.activity_add_edit_kt5, null);

        // Set layout cho alert dialog
        builder.setView(alert);

        final EditText editTextTenSP;
        final EditText editTextDonVi;
        final EditText editTextGiaSP;
        Button buttonLuu;
        Button buttonThoat;

        // Tham chiếu các đối tượng có trên giao diện dialog vừa được set
        editTextTenSP = alert.findViewById(R.id.editTextTenSP);
        editTextDonVi = alert.findViewById(R.id.editTextDonVi);
        editTextGiaSP = alert.findViewById(R.id.editTextGiaSP);
        buttonLuu = alert.findViewById(R.id.buttonLuu);
        buttonThoat = alert.findViewById(R.id.buttonThoat);

        // Tạo dialog và hiển thị
        builder.show();

        // Bắt sự kiện click vào nút Lưu
        buttonLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product_KT5 productKT5 = new Product_KT5();
                productKT5.setTenSp(editTextTenSP.getText().toString());
                productKT5.setDonVi(editTextDonVi.getText().toString());
                String s = editTextGiaSP.getText().toString();
                s = s.replace(",", "");
                double price = Double.parseDouble(s);
                productKT5.setGiaSp(price);
                productAdapterKT5.add(productKT5);
                productAdapterKT5.notifyDataSetChanged();
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