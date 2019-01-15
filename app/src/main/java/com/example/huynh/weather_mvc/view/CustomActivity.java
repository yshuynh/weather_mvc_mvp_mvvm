package com.example.huynh.weather_mvc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.huynh.weather_mvc.R;
import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.presenter.CustomPresenter;
import com.example.huynh.weather_mvc.view.RecyclerViewAdapter;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity implements CustomView {

    CustomPresenter customPresenter = new CustomPresenter(this);
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        customPresenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        customPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        customPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        customPresenter.onDestroy();
    }

    @Override
    public void onUpdateRecyclerView(ArrayList<String> listCity) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, MyCityList.getInstance().getMyAllCityList());
        recyclerView.setAdapter(adapter);
    }
}
