package com.example.eoin_pc.repository_pattern_example.data.entity.mapper;

import android.database.Cursor;

import com.example.eoin_pc.repository_pattern_example.domain.DailyWeather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class CursorEntityMapper {




    public CursorEntityMapper()
    {
    }




    /**
     * convert from cursor to dailyweather type!!
     * @param cursor
     * @return
     */

    public List<DailyWeather> converttoWeatherList(Cursor cursor)
    {
        ArrayList<DailyWeather> weatherlist = new ArrayList<>();
        return weatherlist;
    }
}
