package com.app.myptp;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class BaseActivity extends AppCompatActivity {
    Context context=this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public void toastShow(String txt) {
        Toast.makeText(this.getApplicationContext(),txt,Toast.LENGTH_SHORT).show();

    }

    public void newStartActivity(Class activity){
        Intent i = new Intent(getApplicationContext(),activity);
        startActivity(i);
    }
}
