package com.example.huynh.weather_mvc.presenter;

import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.view.MainActivity.MainActivityView;

public class MainPresenter implements Presenter {

    MainActivityView mainView;

    public MainPresenter(MainActivityView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
        mainView.onUpdateViewPager(MyCityList.getInstance().getMyCityList());
    }

    @Override
    public void onDestroy() {

    }
}
