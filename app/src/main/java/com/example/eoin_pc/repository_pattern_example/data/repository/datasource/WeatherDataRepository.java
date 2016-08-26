package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import com.example.eoin_pc.repository_pattern_example.domain.DailyWeather;
import com.example.eoin_pc.repository_pattern_example.domain.WeatherRepository;

import java.util.List;

import rx.Observable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class WeatherDataRepository implements WeatherRepository{


    private WeatherDataStoreFactory weatherfactory;


    public WeatherDataRepository() {
        //weatherfactory = new WeatherDataStoreFactory();
    }

    @Override
    public Observable<List<DailyWeather>> getDailyWeather() {

        WeatherDataStore datastore = weatherfactory.getDataStore();
        //return datastore.getWeatherList();

    }

    //possibly dont need to expose to the domain layer
    //as weather is only stored when initially retrieved
    //from the restAPI.


    @Override
    public void saveDailyWeather(Observable<List<DailyWeather>> dailyw) {
        WeatherDataStore datastore  =  weatherfactory.getDiskDataStore();

    }
}
