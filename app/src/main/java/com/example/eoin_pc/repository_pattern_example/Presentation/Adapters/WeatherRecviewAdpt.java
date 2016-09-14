package com.example.eoin_pc.repository_pattern_example.Presentation.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by eoin_a on 14/09/2016.
 */
public class WeatherRecviewAdpt extends RecyclerView.Adapter{

    private List<DailyWeatherEntity> weatherlist;
    private Context cont;

    @Inject
    public WeatherRecviewAdpt(Context contin)
    {
        cont = contin;
        weatherlist = Collections.emptyList();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    public void updateList(List<DailyWeatherEntity> weatherlistin)
    {
        weatherlist = weatherlistin;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
