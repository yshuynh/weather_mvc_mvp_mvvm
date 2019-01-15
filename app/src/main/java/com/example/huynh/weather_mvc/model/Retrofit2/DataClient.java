package com.example.huynh.weather_mvc.model.Retrofit2;

import com.example.huynh.weather_mvc.model.Weather5daysPOJO.Weather5daysPOJO;
import com.example.huynh.weather_mvc.model.WeatherCurrentPOJO.WeatherCurrentPOJO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataClient {
    @GET("weather")
    Call<WeatherCurrentPOJO> getWeather(@Query("APPID") String api_key, @Query("q") String cityName);

    @GET("forecast")
    Call<Weather5daysPOJO> GetWeather5days(@Query("APPID") String api_key, @Query("q") String cityName);
}
