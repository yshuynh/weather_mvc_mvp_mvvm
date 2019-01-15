package com.example.huynh.weather_mvc.presenter;

import com.example.huynh.weather_mvc.view.MainView;

public class MainPresenter implements Presenter {

    MainView mainView;

    public MainPresenter(MainView mainView) {
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
        mainView.onUpdateViewPager();
    }

    @Override
    public void onDestroy() {

    }
}
