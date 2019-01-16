package com.example.huynh.weather_mvc.presenter;

import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.view.CustomActivity.HolderView;

import java.util.ArrayList;

public class HolderPresenter implements Presenter {



    public HolderPresenter() {
    }

    @Override
    public void onCreate() {

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

    public void onBindViewHolderAtPosition(HolderView holder, int position) {
        ArrayList<String> list = MyCityList.getInstance().getMyAllCityList();
        String cityName = list.get(position);
        holder.setCityName(cityName);
        holder.setCheckBox(MyCityList.getInstance().CheckCityName(cityName));
    }

    public void onCheckBoxClicked(String cityName, boolean check) {
        if (check) MyCityList.getInstance().AddNewCity(cityName);
        else MyCityList.getInstance().RemoveCity(cityName);
    }

    public int getItemCount() {
        return MyCityList.getInstance().getMyAllCityList().size();
    }

}
