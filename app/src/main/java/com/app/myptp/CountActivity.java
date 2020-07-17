package com.app.myptp;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.os.Bundle;
import android.widget.TextView;
import com.app.myptp.R;
public class CountActivity extends AppCompatActivity {
    @BindView(R.id.tvNum)
    TextView tvNum;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        ButterKnife.bind(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) { // 현재 UI 스레드가 아니기 때문에 메시지 큐에 Runnable을 등록 함
                    count++;
                    runOnUiThread(new Runnable() {
                        public void run() { // 메시지 큐에 저장될 메시지의 내용

                            tvNum.setText("" + count);
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}