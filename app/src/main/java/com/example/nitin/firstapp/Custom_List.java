package com.example.nitin.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class Custom_List extends AppCompatActivity {

        private ArrayAdapter adapter;
        private android.widget.ListView custom_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__list);

        custom_1=(android.widget.ListView)findViewById(R.id.custom_1);

        String[] name={"GAJENDRA","PIYUSH","ATUL","SHWETA","ANUBHAV","NITESH"};
       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(getListView().getContext(),android.R.layout.simple_list_item_1,name);
        //getListView().setAdapter(adapter);
        ArrayList<String> nameList=new ArrayList<>();



        adapter=new ArrayAdapter(this,R.layout.simplerow,name);
        custom_1.setAdapter(adapter);
    }
}
