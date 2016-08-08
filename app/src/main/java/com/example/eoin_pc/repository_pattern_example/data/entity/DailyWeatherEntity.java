package com.example.eoin_pc.repository_pattern_example.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class DailyWeatherEntity implements Parcelable {


    protected DailyWeatherEntity(Parcel in) {
    }

    public int time;
    public String summary;
    public String icon;
    public int sunriseTime;
    public int sunsetTime;
    public float moonPhase;
    public float precipIntensity;
    public int precipIntensityMaxTime;
    public float precipProbability;
    public String precipType;
    public float humidity;
    public float pressure;
    public float apparentTempartureMax;
    public int temperatureMaxTime;



    public static final Creator<DailyWeatherEntity> CREATOR = new Creator<DailyWeatherEntity>() {
        @Override
        public DailyWeatherEntity createFromParcel(Parcel in) {
            return new DailyWeatherEntity(in);
        }

        @Override
        public DailyWeatherEntity[] newArray(int size) {
            return new DailyWeatherEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
