package com.example.eoin_pc.repository_pattern_example.domain;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class DailyWeather {


    //DailyWeather doesnt posesses a moonphase. for demo puroses.!!

    private int time;
    private String summary;
    private String icon;
    private int sunriseTime;
    private int sunsetTime;
    private float precipIntensity;
    private int precipIntensityMaxTime;
    private float precipProbability;
    private String precipType;
    private float humidity;
    private float pressure;
    private float apparentTempertureMax;
    private int temperatureMaxTime;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(int sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public int getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(int sunsetTime) {
        this.sunsetTime = sunsetTime;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public DailyWeather()
    {

    }
}
