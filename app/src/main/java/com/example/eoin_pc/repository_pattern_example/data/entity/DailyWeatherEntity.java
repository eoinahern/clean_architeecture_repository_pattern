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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(int sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(int sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public float getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
    }

    public float getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(float precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public int getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(int precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public float getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(float precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getApparentTempertureMax() {
        return apparentTempertureMax;
    }

    public void setApparentTempertureMax(float apparentTempertureMax) {
        this.apparentTempertureMax = apparentTempertureMax;
    }

    public int getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(int temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
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
    private float pressure;


    @SerializedName("apparentTemperatureMax")
    private float apparentTempertureMax;

    @SerializedName("temperatureMaxTime")
    private int temperatureMaxTime;





}
