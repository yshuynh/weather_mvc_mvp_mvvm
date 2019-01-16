package com.example.huynh.weather_mvc.presenter;

import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.view.CustomActivity.CustomActivityView;

public class CustomPresenter implements Presenter {

    CustomActivityView customView;

    public CustomPresenter(CustomActivityView customView) {
        this.customView = customView;
    }

    @Override
    public void onCreate() {
        customView.onUpdateRecyclerView();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

}
