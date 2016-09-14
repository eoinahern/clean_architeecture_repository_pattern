package com.example.eoin_pc.repository_pattern_example.domain;

import android.content.Context;

import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataRepository;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.GetWeather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.Scheduler;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by eoin_pc on 08/09/2016.
 */
public class GetWeatherTest {

    private GetWeather getweather;

    @Mock private WeatherRepository weatherrepo;
    @Mock private Context cont;
    @Mock Observable obs;
    @Mock Scheduler mockmainscheduler;
    @Mock Scheduler mockioscheduler;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        getweather = new GetWeather(weatherrepo, mockmainscheduler, mockioscheduler);
    }


    @Test
    public void testBuildObservable()
    {
        when(weatherrepo.getDailyWeather()).thenReturn(obs);
        //execute
        getweather.buildUseCaseObservable();
        //assert and verify
        verify(weatherrepo, times(1)).getDailyWeather();
        verifyNoMoreInteractions(weatherrepo);

        Assert.assertEquals(obs, getweather.buildUseCaseObservable());

    }
}
