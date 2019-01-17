package com.example.huynh.weather_mvc.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.huynh.weather_mvc.R;
import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.viewmodel.CustomViewModel;
import com.example.huynh.weather_mvc.viewmodel.PagerViewModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    CustomViewModel customViewModel;

    public RecyclerViewAdapter(Context context, CustomViewModel customViewModel) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.customViewModel = customViewModel;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

//        public TextView title, year, genre;
        public TextView cityName;
        public CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.cityName);
            checkBox = itemView.findViewById(R.id.checkbox);


            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customViewModel.onClickCheckBox(cityName.getText().toString(), checkBox.isChecked());
//                    if (checkBox.isChecked()) MyCityList.getInstance().AddNewCity(cityName.getText().toString());
//                    else MyCityList.getInstance().RemoveCity(cityName.getText().toString());
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.recycler_view_row,parent,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
//        String name = mList.get(position);
//        holder.cityName.setText(name);
//        holder.checkBox.setChecked(MyCityList.getInstance().CheckCityName(name));
        customViewModel.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return customViewModel.getItemCount();
    }

}