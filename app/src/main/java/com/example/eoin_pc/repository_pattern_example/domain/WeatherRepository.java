package com.example.eoin_pc.repository_pattern_example.domain;

import java.util.List;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public interface WeatherRepository {

    List<DailyWeather>  getDailyWeather();
    void saveDailyWeather(List<DailyWeather> dailyw);
}
