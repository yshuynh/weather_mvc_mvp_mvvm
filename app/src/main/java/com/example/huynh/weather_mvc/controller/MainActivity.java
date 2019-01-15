package com.example.huynh.weather_mvc.controller;

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
import android.widget.Button;
import android.widget.TextView;

import com.example.huynh.weather_mvc.R;
import com.example.huynh.weather_mvc.model.MyCityList;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Log.d(TAG, "onResume: ");
        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(
                getSupportFragmentManager(),
                MyCityList.getInstance().getMyCityList());
        viewPager.setAdapter(customViewPagerAdapter);
    }
}
