package com.app.myptp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.app.myptp.MainActivity;
import com.app.myptp.BaseActivity;
import com.app.myptp.R;

public class FirstActivity extends BaseActivity {
    private final int SPLACH_DISPLAY_LENGTH = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first);
        subThread st = new subThread();
        st.start();
    }

    class subThread extends Thread{
        public subThread(){super();}
        @Override
        public void run(){
            try{
                Thread.sleep(SPLACH_DISPLAY_LENGTH);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            Log.d("splash 화면","splash종료");
            newStartActivity(MainActivity.class);
            finish();
        }

    }
}
