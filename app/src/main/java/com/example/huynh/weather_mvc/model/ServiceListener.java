package com.example.huynh.weather_mvc.model;

import com.example.huynh.weather_mvc.model.Weather5daysPOJO.Weather5daysPOJO;
import com.example.huynh.weather_mvc.model.WeatherCurrentPOJO.WeatherCurrentPOJO;

public interface ServiceListener {
    void onResponseCallCurrentWeather(WeatherCurrentPOJO detail);
    void onResponseCall5dayWeather(Weather5daysPOJO detail5day);
}
