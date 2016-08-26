package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import com.example.eoin_pc.repository_pattern_example.data.Web.RestAPICalls;
import com.example.eoin_pc.repository_pattern_example.data.Web.RestAPICallsImp;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class DiskWeatherDataStore implements WeatherDataStore {

    //mapper required here!!!



    public DiskWeatherDataStore()
    {


    }

    @Override
    public Observable<List<DailyWeatherEntity>> getWeatherList() {
        return null;
    }

    @Override
    public void saveWeatherData(Observable<List<DailyWeatherEntity>> dailyw) {

    }
}
