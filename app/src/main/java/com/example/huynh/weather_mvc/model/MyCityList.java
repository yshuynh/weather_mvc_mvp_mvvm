package com.example.huynh.weather_mvc.model;

import android.util.Log;

import com.example.huynh.weather_mvc.model.Retrofit2.APIUtils;
import com.example.huynh.weather_mvc.model.Retrofit2.DataClient;
import com.example.huynh.weather_mvc.model.WeatherCurrentPOJO.WeatherCurrentPOJO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCityList {
    public static MyCityList instance = null;

    public static MyCityList getInstance() {
        if (instance == null) {
            instance = new MyCityList();
        }
        return instance;
    }

    private String TAG = "MyCityList";
    private ArrayList<String> myAllCityList;
    private ArrayList<String> myCityList;

    public MyCityList() {
        myCityList = new ArrayList<String>();
        myCityList.add("London");
        myCityList.add("Danang");
        myAllCityList = new ArrayList<String>();
        myAllCityList.add("London");
        myAllCityList.add("Danang");
        myAllCityList.add("Hanoi");
        myAllCityList.add("Thanh pho ho chi minh");
    }

    public ArrayList<String> getMyCityList() {
        return myCityList;
    }

    //    public ArrayList<WeatherCurrentPOJO> getListWeatherCurrentPOJO() {
//        final ArrayList<WeatherCurrentPOJO> list = new ArrayList<WeatherCurrentPOJO>();
//
//        for (String cityName : myCityList) {
//            DataClient dataClient = APIUtils.getData();
//            Call<WeatherCurrentPOJO> callback = dataClient.getWeather(APIUtils.API_KEY, cityName);
//            callback.enqueue(new Callback<WeatherCurrentPOJO>() {
//                @Override
//                public void onResponse(Call<WeatherCurrentPOJO> call, Response<WeatherCurrentPOJO> response) {
//                    list.add(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<WeatherCurrentPOJO> call, Throwable t) {
//                    Log.d(TAG, "onFailure: " + t.getMessage());
//                }
//            });
//        }
//
//
//        return list;
//    }


    public ArrayList<String> getMyAllCityList() {
        return myAllCityList;
    }

    public void AddNewCity(String name) {
        if (!myCityList.contains(name)) myCityList.add(name);
    }

    public void RemoveCity(String name) {
        myCityList.remove(name);
    }
    public boolean CheckCityName(String name) {
        return myCityList.contains(name);
    }
}
