package com.example.huynh.weather_mvc.presenter;

import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.view.CustomView;

public class CustomPresenter implements Presenter {

    CustomView customView;

    public CustomPresenter(CustomView customView) {
        this.customView = customView;
    }

    @Override
    public void onCreate() {
        customView.onUpdateRecyclerView(MyCityList.getInstance().getMyAllCityList());
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
