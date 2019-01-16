package com.example.huynh.weather_mvc.presenter;

import com.example.huynh.weather_mvc.model.Service;
import com.example.huynh.weather_mvc.model.ServiceListener;
import com.example.huynh.weather_mvc.model.Weather5daysPOJO.Weather5daysPOJO;
import com.example.huynh.weather_mvc.model.WeatherCurrentPOJO.WeatherCurrentPOJO;
import com.example.huynh.weather_mvc.view.MainActivity.PagerView;

public class PagerPresenter implements Presenter {

    PagerView pagerView;

    public PagerPresenter(PagerView pagerView) {
        this.pagerView = pagerView;
    }

    public void getData(String cityName) {
        ServiceListener serviceListener = new ServiceListener() {
            @Override
            public void onResponseCallCurrentWeather(WeatherCurrentPOJO detail) {
                pagerView.onResponseCallCurrentWeather(detail);
            }

            @Override
            public void onResponseCall5dayWeather(Weather5daysPOJO detail5day) {
                pagerView.onResponseCall5dayWeather(detail5day);
            }
        };
        Service service = new Service(serviceListener);
        service.CallAPICurrentWeather(cityName);
        service.CallAPI5dayWeather(cityName);
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

}
