package com.example.eoin_pc.repository_pattern_example.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eoin_pc on 22/09/2016.
 */
public class DailyWeatherEntityList {

    @SerializedName("data")
    public List<DailyWeatherEntity> weatherlist;

    public DailyWeatherEntityList(List<DailyWeatherEntity> weatherlistin)
    {
        this.weatherlist = weatherlistin;
    }


    public   List<DailyWeatherEntity> getWeatherList()
    {
        return weatherlist;
    }

    public void setWeatherList(List<DailyWeatherEntity> weatherlistin)
    {
        this.weatherlist = weatherlistin;
    }

}
