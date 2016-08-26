package com.example.eoin_pc.repository_pattern_example.data.entity.mapper;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.domain.DailyWeather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eoin_a on 26/08/2016.
 */
public class WeatherMapper {

    public WeatherMapper()
    {
    }


    public List<DailyWeather> transform(List<DailyWeatherEntity> dweatherent)
    {
        List<DailyWeather> dwlist = new ArrayList<>();
        for(DailyWeatherEntity dw : dweatherent)
        {
            DailyWeather tempdw = convert(dw);
            dwlist.add(tempdw);
        }

        return dwlist;
    }


    /**
     * convert DailyweatherEntity to Dailyweather
     *
     * @param dwe
     * @return
     */


    private DailyWeather convert(DailyWeatherEntity dwe)
    {
       DailyWeather dweather = new DailyWeather();

        dweather.setTime(dwe.getTime());
        dweather.setIcon(dwe.getIcon());
        dweather.setSummary(dwe.getSummary());
        dweather.setSunriseTime(dwe.getSunriseTime());
        dweather.setSunsetTime(dwe.getSunsetTime());
        dweather.setPrecipIntensity(dwe.getPrecipIntensity());
        dweather.setPrecipIntensityMaxTime(dwe.getPrecipIntensityMaxTime());



        return dweather;
    }



}
