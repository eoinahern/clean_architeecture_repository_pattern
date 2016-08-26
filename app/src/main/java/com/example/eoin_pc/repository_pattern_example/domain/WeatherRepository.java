package com.example.eoin_pc.repository_pattern_example.domain;

import java.util.List;

import rx.Observable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public interface WeatherRepository {

    Observable<List<DailyWeather>> getDailyWeather();
    void saveDailyWeather(Observable<List<DailyWeather>> dailyw);
}
