package com.example.eoin_pc.repository_pattern_example.Presentation.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eoin_pc.repository_pattern_example.R;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by eoin_a on 14/09/2016.
 */
public class WeatherRecviewAdpt extends RecyclerView.Adapter<WeatherRecviewAdpt.ViewHolder>{

    private List<DailyWeatherEntity> weatherlist;
    private Context cont;
    private LayoutInflater inflater;

    @Inject
    public WeatherRecviewAdpt(Context contin)
    {
        cont = contin;
        weatherlist = Collections.emptyList();
        inflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public WeatherRecviewAdpt.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.weather_recview_row, parent, false);
        return  new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ViewHolder h, int pos) {

        DailyWeatherEntity  weatheritem = weatherlist.get(pos);
        h.forecasttxt.setText(weatheritem.getSummary());
    }

    public void updateList(List<DailyWeatherEntity> weatherlistin)
    {

        Log.d("update List called", "update");
        Log.d("list length", String.valueOf(weatherlistin.size()));
        weatherlist = weatherlistin;
        this.notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return weatherlist.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{


       public TextView forecasttxt;

        public ViewHolder(View v) {
            super(v);
            forecasttxt = (TextView)  v.findViewById(R.id.forecast);
        }
    }




}
