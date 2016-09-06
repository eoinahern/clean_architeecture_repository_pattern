package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import android.content.Context;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.data.entity.mapper.WeatherMapper;
import com.example.eoin_pc.repository_pattern_example.domain.DailyWeather;
import com.example.eoin_pc.repository_pattern_example.domain.WeatherRepository;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class WeatherDataRepository implements WeatherRepository{


    private WeatherDataStoreFactory weatherfactory;
    private WeatherMapper weatherMapper;

    @Singleton
    public WeatherDataRepository(Context cont) {
        weatherfactory = new WeatherDataStoreFactory(cont);
        weatherMapper = new WeatherMapper();
    }

    @Override
    public Observable<List<DailyWeather>> getDailyWeather() {
        WeatherDataStore datastore = weatherfactory.getDataStore();
        Observable<List<DailyWeatherEntity>> obs = datastore.getWeatherList();

        if(datastore instanceof CloudWeatherDataStore)
            saveDailyWeather(obs);

        return obs.map(this.weatherMapper::transform);
    }

    //possibly dont need to expose to the domain layer
    //as weather is only stored when initially retrieved
    //from the restAPI.


    @Override
    public void saveDailyWeather(Observable<List<DailyWeatherEntity>> dailyw) {
        WeatherDataStore datastore  =  weatherfactory.getDiskDataStore();
        datastore.saveWeatherData(dailyw);

    }
}
