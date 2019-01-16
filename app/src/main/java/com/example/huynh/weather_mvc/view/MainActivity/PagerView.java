package com.example.huynh.weather_mvc.view.MainActivity;

import android.view.View;

import com.example.huynh.weather_mvc.model.Weather5daysPOJO.Weather5daysPOJO;
import com.example.huynh.weather_mvc.model.WeatherCurrentPOJO.WeatherCurrentPOJO;

public interface PagerView {
    public void onResponseCallCurrentWeather(WeatherCurrentPOJO detail);
    public void onResponseCall5dayWeather(Weather5daysPOJO detail5day);
}
