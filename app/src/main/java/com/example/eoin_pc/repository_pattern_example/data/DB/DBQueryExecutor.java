package com.example.eoin_pc.repository_pattern_example.data.DB;

import android.content.Context;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.data.entity.mapper.CursorEntityMapper;

import java.util.List;

import rx.Observable;

/**
 * Created by eoin_pc on 10/08/2016.
 */
public class DBQueryExecutor {


    private WeatherDBHelper wdbhelper;
    private Context cont;
    private CursorEntityMapper cursormapper;

    public DBQueryExecutor(Context contin)
    {
        cont = contin;
        wdbhelper = WeatherDBHelper.getHelper(cont);
        cursormapper = new CursorEntityMapper();
    }



    public Observable<List<DailyWeatherEntity>> getDailyWeatherList()
    {
        return Observable.create(subscriber -> {
            //do stuff here!!!!
        });
    }





}
