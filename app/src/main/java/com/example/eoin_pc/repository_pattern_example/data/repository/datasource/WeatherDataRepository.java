package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import com.example.eoin_pc.repository_pattern_example.domain.DailyWeather;
import com.example.eoin_pc.repository_pattern_example.domain.WeatherRepository;

import java.util.List;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class WeatherDataRepository implements WeatherRepository{


    private WeatherDataStoreFactory weatherfactory;


    public WeatherDataRepository() {
        weatherfactory = new WeatherDataStoreFactory();
    }

    @Override
    public List<DailyWeather> getDailyWeather() {

        WeatherDataStore datastore = weatherfactory.getDataStore();
        //return datastore.getWeatherList();

    }

    @Override
    public void saveDailyWeather(List<DailyWeather> dailyw) {
        WeatherDataStore datastore  =  weatherfactory.getDiskDataStore();


        //need to map data. may be unnecesary step!!
        // datastore.saveWeatherData(dailyw);
    }
}
