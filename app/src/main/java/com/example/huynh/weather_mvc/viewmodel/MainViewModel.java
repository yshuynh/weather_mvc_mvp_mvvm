package com.example.huynh.weather_mvc.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.view.CustomViewPagerAdapter;

import java.util.ArrayList;

public class MainViewModel implements ViewModel{

    private MutableLiveData<ArrayList<String>> list;

    public MainViewModel() {
        list = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<String>> getList() {
        return list;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        list.setValue(MyCityList.getInstance().getMyCityList());
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}
