package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import android.content.res.Resources;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.List;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class CloudWeatherDataStore implements WeatherDataStore {




    @Override
    public List<DailyWeatherEntity> getWeatherList() {
        return null;
    }

    @Override
    public void saveWeatherData(List<DailyWeatherEntity> dailyw) {
            throw new UnsupportedOperationException();
    }
}
