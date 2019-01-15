package com.example.huynh.weather_mvc.model;

import android.util.Log;

import com.example.huynh.weather_mvc.model.Retrofit2.APIUtils;
import com.example.huynh.weather_mvc.model.Retrofit2.DataClient;
import com.example.huynh.weather_mvc.model.Weather5daysPOJO.Weather5daysPOJO;
import com.example.huynh.weather_mvc.model.WeatherCurrentPOJO.WeatherCurrentPOJO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Service {
    ServiceListener listener;

    public Service(ServiceListener listener) {
        this.listener = listener;
    }

    public void CallAPICurrentWeather(String cityName) {
        DataClient dataClient = APIUtils.getData();
        Call<WeatherCurrentPOJO> callback = dataClient.getWeather(APIUtils.API_KEY, cityName);
        callback.enqueue(new Callback<WeatherCurrentPOJO>() {
            @Override
            public void onResponse(Call<WeatherCurrentPOJO> call, Response<WeatherCurrentPOJO> response) {
                listener.onResponseCallCurrentWeather(response.body());
            }

            @Override
            public void onFailure(Call<WeatherCurrentPOJO> call, Throwable t) {
                Log.d("BBB", "onFailure: " + t.getMessage());
            }
        });
    }

    public void CallAPI5dayWeather(String cityName) {
        DataClient dataClient = APIUtils.getData();
        Call<Weather5daysPOJO> callback5day = dataClient.GetWeather5days(APIUtils.API_KEY, cityName);
        callback5day.enqueue(new Callback<Weather5daysPOJO>() {
            @Override
            public void onResponse(Call<Weather5daysPOJO> call, Response<Weather5daysPOJO> response) {
                listener.onResponseCall5dayWeather(response.body());
            }

            @Override
            public void onFailure(Call<Weather5daysPOJO> call, Throwable t) {
                Log.d("BBB", "onFailure:5day " + t.getMessage());
            }
        });
    }
}
