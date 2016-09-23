package com.example.eoin_pc.repository_pattern_example.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eoin_pc on 23/09/2016.
 */


public class DailyObj {


    @SerializedName("data")
    private List<DailyWeatherEntity> dailywlist;


    public DailyObj()
    {
    }

    public List<DailyWeatherEntity> getdailywlist()
    {
        return dailywlist;
    }
}
