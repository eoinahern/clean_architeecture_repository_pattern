package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public interface WeatherDataStore {

        Observable<List<DailyWeatherEntity>> getWeatherList();
        void saveWeatherData(Observable<List<DailyWeatherEntity>> dailyw);
}
