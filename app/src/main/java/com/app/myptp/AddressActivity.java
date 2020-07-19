package com.app.myptp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.text.TextWatcher;
import android.text.Editable;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddressActivity extends AppCompatActivity {

    private ListView itemListView = null;
    ArrayList<Item> itemlst = new ArrayList<>();
    CustomListAdapter adapter;
    ListView custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        itemListView = findViewById(R.id.addressList);
        itemlst = generateMyArrayList();

        itemListView.setAdapter(adapter);
        adapter = new CustomListAdapter(this, itemlst);
       EditText editTextFilter = (EditText)findViewById(R.id.editTextFilter);
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = editTextFilter.getText().toString();
                search(str);
            }
        });
    }
    public void search(String str){
    itemlst.clear();
    if(str.length()==0) itemlst.addAll(generateMyArrayList());
    else{
        for(int i = 0;i < generateMyArrayList().size(); i++)
        {
            if (generateMyArrayList().get(i).getItemName().toLowerCase().contains(str));
            {
                itemlst.add(generateMyArrayList().get(i));
            }
          /*      if (generateItemList().get(i).getItemDescription().toLowerCase().contains(search_text))
                {
                    item_lists.add(generateItemList().get(i));
                }*/
        }
    }
        adapter.notifyDataSetChanged();



    }

    private ArrayList<Item> generateMyArrayList(){
        String itemName[] = getResources().getStringArray(R.array.items_name);
        String itemDescription[] = getResources().getStringArray(R.array.item_description);

        ArrayList<Item> list = new ArrayList<>();

        for(int i=0;i<itemName.length;i++){
            list.add(new Item(itemName[i],itemDescription[i]));
        }

        return list;

    }
}