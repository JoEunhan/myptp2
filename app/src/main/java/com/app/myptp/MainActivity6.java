package com.app.myptp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {

    private Context mContext;



    private ArrayList<String> array_mountain;

    private ListView mListView;

    private Adapter Adapter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main6);

        this.mContext = getApplicationContext();


        mListView = (ListView) findViewById(R.id.list_mountain);


        // 데이터 생성

        array_mountain = new ArrayList<>();

        array_mountain.add("1번째");
        array_mountain.add("2번째");
        array_mountain.add("3번째");
        array_mountain.add("4번째");
        array_mountain.add("5번째");
        array_mountain.add("6번째");
        array_mountain.add("7번째");
        array_mountain.add("8번째");
        Adapter = new Adapter(mContext,array_mountain);
        mListView.setAdapter(Adapter);

    }
}
