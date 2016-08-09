package com.example.eoin_pc.repository_pattern_example.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class DailyWeatherEntity {


    protected DailyWeatherEntity() {
    }


    @SerializedName("time")
    private int time;

    @SerializedName("summary")
    private String summary;

    @SerializedName("icon")
    private String icon;


    @SerializedName("sunriseTime")
    private int sunriseTime;

    @SerializedName("sunsetTime")
    public int sunsetTime;

    @SerializedName("moonPhase")
    private float moonPhase;

    @SerializedName("precipIntensity")
    private float precipIntensity;

    @SerializedName("precipIntensityMaxTime")
    public int precipIntensityMaxTime;

    @SerializedName("precipProbability")
    private float precipProbability;

    @SerializedName("precipType")
    private String precipType;


    @SerializedName("humidity")
    private float humidity;

    @SerializedName("pressure")
    public float pressure;


    @SerializedName("apparentTemperatureMax")
    public float apparentTempertureMax;

    @SerializedName("temperatureMaxTime")
    public int temperatureMaxTime;



}
