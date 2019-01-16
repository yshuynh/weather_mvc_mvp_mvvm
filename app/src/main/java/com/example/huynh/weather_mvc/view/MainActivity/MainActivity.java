package com.example.huynh.weather_mvc.view.MainActivity;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.huynh.weather_mvc.R;
import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.presenter.MainPresenter;
import com.example.huynh.weather_mvc.view.CustomActivity.CustomActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    String TAG = "MainActivity";
    ViewPager viewPager;

    MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter.onCreate();

        //Remove Status Bar + Navigation
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        Log.d(TAG, "onCreate: " + MyCityList.getInstance().getMyCityList().size());
        viewPager = findViewById(R.id.viewPager);

//        Floating Action Button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }

    @Override
    public void onUpdateViewPager(ArrayList<String> cityList) {
        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(
                getSupportFragmentManager(),
                cityList);
        viewPager.setAdapter(customViewPagerAdapter);
    }
}
