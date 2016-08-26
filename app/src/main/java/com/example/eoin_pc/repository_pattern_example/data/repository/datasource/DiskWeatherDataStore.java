package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import android.content.Context;

import com.example.eoin_pc.repository_pattern_example.data.DB.DBQueryExecutor;
import com.example.eoin_pc.repository_pattern_example.data.DB.WeatherDBHelper;
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

    private DBQueryExecutor dbQueryExecutor;

    public DiskWeatherDataStore(Context contin)
    {
        dbQueryExecutor = new DBQueryExecutor(contin);
    }

    @Override
    public Observable<List<DailyWeatherEntity>> getWeatherList() {
       return dbQueryExecutor.getDailyWeatherList();
    }

    @Override
    public void saveWeatherData(Observable<List<DailyWeatherEntity>> dailyw) {

    }
}
