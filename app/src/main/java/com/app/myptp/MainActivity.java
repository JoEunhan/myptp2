package com.app.myptp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener,View.OnLongClickListener{
    @BindView(R.id.linearlayout_1) Button linearlayout1;
    @BindView(R.id.linearlayout_2) Button linearlayout2;
    @BindView(R.id.linearlayout_3) Button linearlayout3;
    @BindView(R.id.image2) Button img2;
    @BindView(R.id.calculator) Button cal;
    @BindView(R.id.lifecycle) Button lfc;
    @BindView(R.id.listview) Button lst;
    @BindView(R.id.phonebook) Button phone;

    @BindView(R.id.mainTableLayout)
    TableLayout mainTableLayout;
    Context mcontext =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        connectOnClickListener();
        linearlayout1.setOnLongClickListener(this);
        img2.setOnLongClickListener(this);
        cal.setOnLongClickListener(this);
        lfc.setOnLongClickListener(this);
        lst.setOnLongClickListener(this);
        phone.setOnLongClickListener(this);

    }


    @Override
    public boolean onLongClick(View v) {
        switch(v.getId()){
            case R.id.linearlayout_1:
                toastShow("첫번째 layout");
                newStartActivity(MainActivity4.class);
                break;
            case R.id.linearlayout_2:
                toastShow("두번째 layout");
                newStartActivity(MainActivity5.class);
                break;
            case R.id.linearlayout_3:
                toastShow("세번째 layout");
                newStartActivity(MainActivity2.class);
                break;
            case R.id.image2:
                toastShow("img2");
                newStartActivity(MainActivity3.class);
                break;
            case R.id.calculator:
                toastShow("계산기");
                newStartActivity(CalculatorActivity.class);
                break;
            case R.id.lifecycle:
                toastShow("수명주기");
               newStartActivity(LifecycleActivity.class);
                break;
            case R.id.listview:
                toastShow("list view");
                newStartActivity(MainActivity6.class);
                break;
            case R.id.phonebook:
                toastShow("phonebook");
                newStartActivity(AddressActivity.class);
                break;

        }
        return true;
    }




    /*
   테이블 레이아웃에서 버튼 가져오기
   return List<View>
 */
    public List<View> getAllButtons(ViewGroup layout){
        List<View> viewList = new ArrayList<>();
        for(int i =0; i< layout.getChildCount(); i++){
            View v =layout.getChildAt(i); //해당 테이블로우 전부 가져오기
            viewList.addAll(v.getTouchables()); //해당 테이블로우의 버튼 id 전부 가져오기
        }
        return viewList;
    }
    /*
        view 리스너 연결
     */
    private void connectOnClickListener () {
        Log.d("test","========================= connectOnClickListener =======================");

        List<View> btnList = getAllButtons(mainTableLayout);
        for (View btn:btnList) {
            btn.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linearlayout_1:
                toastShow("test");
                newStartActivity(MainActivity2.class);
                break;
            case R.id.image2:
                toastShow("img2");
                newStartActivity(MainActivity3.class);
                break;
            case R.id.calculator:
                toastShow("계산기");
                newStartActivity(CalculatorActivity.class);
                break;
            case R.id.lifecycle:
                toastShow("수명주기");
                newStartActivity(LifecycleActivity.class);
                break;
            case R.id.listview:
                toastShow("list view");
                newStartActivity(MainActivity6.class);
                break;
            case R.id.phonebook:
                toastShow("phonebook");
                newStartActivity(AddressActivity.class);
                break;
        }
    }
}
