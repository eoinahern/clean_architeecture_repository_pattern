package com.example.eoin_pc.repository_pattern_example.data.DB;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

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

            try
            {
                Cursor cursor = wdbhelper.getAllWeather();
                List<DailyWeatherEntity> templist = cursormapper.converttoWeatherList(cursor);

                if(templist.size() > 0)
                {
                    subscriber.onNext(cursormapper.converttoWeatherList(cursor));
                    subscriber.onCompleted();
                }

                subscriber.onError(new Resources.NotFoundException());
            }
           catch(Exception e)
           {
               Log.e("error reading db", "error");
              subscriber.onError(new SQLException());
           }
        });
    }





}
