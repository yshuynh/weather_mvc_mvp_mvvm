package com.example.huynh.weather_mvc.viewmodel;

import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.view.RecyclerViewAdapter;

public class CustomViewModel implements ViewModel {
    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    public void onClickCheckBox(String text, boolean check) {
        if (check) {
            MyCityList.getInstance().AddNewCity(text);
        } else {
            MyCityList.getInstance().RemoveCity(text);
        }
    }

    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        String name = MyCityList.getInstance().getMyAllCityList().get(position);
        holder.cityName.setText(name);
        holder.checkBox.setChecked(MyCityList.getInstance().CheckCityName(name));
    }
}
