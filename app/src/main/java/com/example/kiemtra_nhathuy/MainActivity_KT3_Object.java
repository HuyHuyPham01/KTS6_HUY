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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiemtra_nhathuy.model.Contact;

import java.util.ArrayList;

public class MainActivity_KT3_Object extends AppCompatActivity {
    ListView listView_Objetc;
    TextView textViewID,textViewName,textViewPhone;
    EditText editTextID,editTextName,editTextPhone;
    Button buttonSave;
    ArrayAdapter<Contact> arrayAdapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt3_object);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ListView Cơ Bản - Object");
        actionBar.setDisplayHomeAsUpEnabled(true);

        textViewID = findViewById(R.id.textViewID);
        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhone);
        editTextID = findViewById(R.id.editTextID);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        listView_Objetc = findViewById(R.id.listView_Object);
        buttonSave = findViewById(R.id.buttonSave);

        arrayAdapterContact = new ArrayAdapter<Contact>(MainActivity_KT3_Object.this, android.R.layout.simple_list_item_1);
        listView_Objetc.setAdapter(arrayAdapterContact);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLySave();
            }
        });


        listView_Objetc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = arrayAdapterContact.getItem(position);
                editTextID.setText(c.getId()+"");
                editTextName.setText(c.getName());
                editTextPhone.setText(c.getPhone()+"");
            }
        });

        listView_Objetc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = arrayAdapterContact.getItem(position);

                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity_KT3_Object.this);

                //Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý xoá không?");

                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        arrayAdapterContact.remove(c);
                        Toast.makeText(MainActivity_KT3_Object.this,"Deleted",Toast.LENGTH_SHORT).show();
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
    }

    private void XuLySave() {
        Contact c = new Contact();
        c.setId(Integer.parseInt(editTextID.getText().toString()));
        c.setName(editTextName.getText().toString());
        c.setPhone(editTextPhone.getText().toString());
        arrayAdapterContact.add(c);
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