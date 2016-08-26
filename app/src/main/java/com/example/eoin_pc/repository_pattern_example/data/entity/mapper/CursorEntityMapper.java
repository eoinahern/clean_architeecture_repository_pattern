package com.example.eoin_pc.repository_pattern_example.data.entity.mapper;

import android.database.Cursor;

import com.example.eoin_pc.repository_pattern_example.data.DB.WeatherDBHelper;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
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

    public List<DailyWeatherEntity> converttoWeatherList(Cursor cursor)
    {
        ArrayList<DailyWeatherEntity> weatherlist = new ArrayList<>();
        cursor.moveToFirst();

        try
        {
            while(cursor.moveToNext())
            {
                DailyWeatherEntity dw = createDailyWeather(cursor);
                weatherlist.add(dw);
            }
        }
        finally {
            cursor.close();
        }

        return weatherlist;
    }


    private DailyWeatherEntity createDailyWeather(Cursor cursor)
    {
        DailyWeatherEntity dw = new DailyWeatherEntity();

        dw.setTime(cursor.getInt(cursor.getColumnIndex(WeatherDBHelper.WEATHER_TABLE_NAME)));
        dw.setSummary(cursor.getString(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_SUMMARY)));
        dw.setIcon(cursor.getString(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_ICON)));
        dw.setSunriseTime(cursor.getInt(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_SUNRISETIME)));
        dw.setSunsetTime(cursor.getInt(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_SUNSETTIME)));
        dw.setMoonPhase(cursor.getFloat(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_MOONPHASE)));
        dw.setPrecipIntensity(cursor.getFloat(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_PRECIPINTENSITY)));
        dw.setPrecipIntensityMaxTime(cursor.getInt(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_PRECIPINTENSITYMAXTIME)));
        dw.setPrecipProbability(cursor.getFloat(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_PRECIPPROBABILITY)));
        dw.setPrecipType(cursor.getString(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_PRECIPTYPE)));
        dw.setHumidity(cursor.getFloat(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_HUMIDITY)));
        dw.setPressure(cursor.getFloat(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_PRESSURE)));
        dw.setApparentTempertureMax(cursor.getFloat(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_APPARENTTEMPMAX)));
        dw.setTemperatureMaxTime(cursor.getInt(cursor.getColumnIndex(WeatherDBHelper.WEATHER_COLUMN_TEMPERATUREMAXTIME)));

        return dw;
    }
}
