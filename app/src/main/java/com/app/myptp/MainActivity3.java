package com.app.myptp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {
    Button btn1;
    Button bnt2;
    ImageView img1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn1 =(Button) findViewById(R.id.imgbtn1);
        img1 =(ImageView) findViewById(R.id.imagev1);

        btn1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v){
               btn1.setText("눌렸다");

            }
        });
    }
}
