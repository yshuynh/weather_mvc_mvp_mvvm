package com.example.huynh.weather_mvc.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.huynh.weather_mvc.view.WeatherPage;

import java.util.ArrayList;

public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> list;
    ArrayList<Fragment> fragments;

    public CustomViewPagerAdapter(FragmentManager fragmentManager, ArrayList<String> list) {
        super(fragmentManager);
        this.list = list;
        fragments = new ArrayList<Fragment>();
        for (String cityName : list) {
            fragments.add(new WeatherPage(cityName));
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        frag = fragments.get(position);
        return frag;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        return title;
    }
}