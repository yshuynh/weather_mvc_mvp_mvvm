package com.example.huynh.weather_mvc.controller;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.huynh.weather_mvc.R;
import com.example.huynh.weather_mvc.model.MyCityList;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, MyCityList.getInstance().getMyAllCityList());
        recyclerView.setAdapter(adapter);


    }
}
