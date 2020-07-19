package com.app.myptp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifecycleActivity extends AppCompatActivity {
    private final String Tag="디버그";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tag,"=======onCreate=======");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
    }
    @Override
    protected void onStart(){
        Log.d(Tag,"=======onstart=======");
        super.onStart();

    }
    @Override
    protected void onResume(){
        Log.d(Tag,"=======onresume=======");
        super.onResume();

    }
    @Override
    protected void onPause(){
        Log.d(Tag,"=======onPause=======");
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        Log.d(Tag,"=======onDestroy=======");
        super.onDestroy();
    }
}
