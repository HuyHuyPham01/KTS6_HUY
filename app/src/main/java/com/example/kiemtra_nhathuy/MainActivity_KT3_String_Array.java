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

public class MainActivity_KT3_String_Array extends AppCompatActivity {
    ListView listView_String_Array;
    String [] arrayData;
    ArrayAdapter<String> adapterArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt3_string_array);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("63 Tỉnh/Thành Việt Nam");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView_String_Array = findViewById(R.id.listView_String_Array);
        arrayData = getResources().getStringArray(R.array.myArray);
        adapterArray = new ArrayAdapter<String>(MainActivity_KT3_String_Array.this, android.R.layout.simple_list_item_1,arrayData);
        listView_String_Array.setAdapter(adapterArray);

        listView_String_Array.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity_KT3_String_Array.this, "Bạn chọn: " + arrayData[i], Toast.LENGTH_SHORT).show();
            }
        });
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