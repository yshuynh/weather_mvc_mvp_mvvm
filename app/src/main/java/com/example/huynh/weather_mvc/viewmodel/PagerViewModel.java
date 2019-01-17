package com.example.huynh.weather_mvc.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.example.huynh.weather_mvc.model.Service;
import com.example.huynh.weather_mvc.model.ServiceListener;
import com.example.huynh.weather_mvc.model.Weather5daysPOJO.Weather5daysPOJO;
import com.example.huynh.weather_mvc.model.WeatherCurrentPOJO.WeatherCurrentPOJO;

public class PagerViewModel implements ViewModel {

    private MutableLiveData<WeatherCurrentPOJO> detail;
    private MutableLiveData<Weather5daysPOJO> detail5day;
    String cityName;

    public PagerViewModel(String cityName) {
        this.cityName = cityName;
        detail = new MutableLiveData<>();
        detail5day = new MutableLiveData<>();
    }

    public MutableLiveData<WeatherCurrentPOJO> getDetail() {
        return detail;
    }

    public MutableLiveData<Weather5daysPOJO> getDetail5day() {
        return detail5day;
    }

    @Override
    public void onCreate() {
        ServiceListener serviceListener = new ServiceListener() {
            @Override
            public void onResponseCallCurrentWeather(WeatherCurrentPOJO detail) {
                PagerViewModel.this.detail.setValue(detail);
            }

            @Override
            public void onResponseCall5dayWeather(Weather5daysPOJO detail5day) {
                PagerViewModel.this.detail5day.setValue(detail5day);
            }
        };
        Service service = new Service(serviceListener);
        service.CallAPICurrentWeather(cityName);
        service.CallAPI5dayWeather(cityName);
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
}
