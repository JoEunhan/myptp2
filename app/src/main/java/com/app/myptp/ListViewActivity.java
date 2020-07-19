package com.app.myptp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.nameList)
    ListView nameList;

    private ArrayList<String> MyArrayList = new ArrayList<>() ;
    private String toastMessage = "Click";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        for(int i=0;i<10;i++){
            MyArrayList.add(i+"번째");
        }

        Adapter itemsAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, MyArrayList);
        nameList.setAdapter((ListAdapter)itemsAdapter);


        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

    }
}