package com.example.eoin_pc.repository_pattern_example.domain;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.data.entity.mapper.WeatherMapper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eoin_a on 24/09/2016.
 */

public class WeatherMapperTest {

    private WeatherMapper wmapper;
    private DailyWeatherEntity  dwent;
    private List<DailyWeatherEntity> dwetlist;
    private final String summ = "nice weather";
    private final String icon = "icon";


    @Before
    public void setUp()
    {
        wmapper = new WeatherMapper();
        createFakeDw();
    }



    @Test
    public  void testConvList()
    {

        dwetlist = new ArrayList<>();
        dwetlist.add(dwent);

        List<DailyWeather> wlist = wmapper.transform(dwetlist);

        Assert.assertEquals(1, wlist.size());
        Assert.assertTrue(wlist.get(0) instanceof  DailyWeather);
        Assert.assertEquals(wlist.get(0).getIcon(), icon);
        Assert.assertEquals(wlist.get(0).getSummary(), summ);

    }


    private void createFakeDw()
    {
        dwent  = new DailyWeatherEntity();
        dwent.setSummary(summ);
        dwent.setIcon(icon);

    }
}
