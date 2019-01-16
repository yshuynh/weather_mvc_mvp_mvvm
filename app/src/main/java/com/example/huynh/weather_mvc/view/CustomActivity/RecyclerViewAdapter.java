package com.example.huynh.weather_mvc.view.CustomActivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.huynh.weather_mvc.R;
import com.example.huynh.weather_mvc.model.MyCityList;
import com.example.huynh.weather_mvc.presenter.CustomPresenter;
import com.example.huynh.weather_mvc.presenter.HolderPresenter;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private HolderPresenter presenter;

    public RecyclerViewAdapter(Context context, HolderPresenter presenter) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.presenter = presenter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements HolderView {

//        public TextView title, year, genre;
        public TextView cityName;
        public CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.m_title);
//            genre = (TextView) itemView.findViewById(R.id.m_genre);
//            year = (TextView) itemView.findViewById(R.id.m_year);
            cityName = itemView.findViewById(R.id.cityName);
            checkBox = itemView.findViewById(R.id.checkbox);


            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onCheckBoxClicked(cityName.getText().toString(), checkBox.isChecked());
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(mContext,title.getText(),Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
//                    Toast.makeText(mContext,"Long item clicked " + title.getText() + , Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        @Override
        public void setCityName(String name) {
            this.cityName.setText(name);
        }

        @Override
        public void setCheckBox(boolean check) {
            this.checkBox.setChecked(check);
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
        presenter.onBindViewHolderAtPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

}