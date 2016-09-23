package com.example.eoin_pc.repository_pattern_example.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eoin_pc on 22/09/2016.
 */
public class DailyWeatherEntityList {

    @SerializedName("daily")
    public DailyObj dailyobj;

    public DailyWeatherEntityList( DailyObj dailyobjin)
    {
        dailyobj = dailyobjin;
    }


    public  DailyObj  getDailyObj()
    {
        return  dailyobj;
    }

    public void setWeatherList( DailyObj dailyobjin)
    {
        dailyobj = dailyobjin;
    }

}
