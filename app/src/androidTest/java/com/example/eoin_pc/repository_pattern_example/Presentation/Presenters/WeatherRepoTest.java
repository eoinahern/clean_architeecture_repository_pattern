package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.data.entity.mapper.WeatherMapper;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataRepository;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataStore;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataStoreFactory;
import com.example.eoin_pc.repository_pattern_example.domain.DailyWeather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.hamcrest.Matchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eoin_pc on 20/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class WeatherRepoTest {


    private WeatherDataStoreFactory mockwdsfactory;
    private WeatherMapper mockmapper;
    private WeatherDataRepository wdrepo;
    private WeatherDataStore wdstore;

    Observable<List<DailyWeatherEntity>> observable;
    Observable<Object> observable2;

    @Before
    public void Setup()
    {
        mockmapper = mock(WeatherMapper.class);
        mockwdsfactory = mock(WeatherDataStoreFactory.class);
        wdstore = mock(WeatherDataStore.class);
        observable = mock(Observable.class);
        observable2 = mock(Observable.class);

        wdrepo = new WeatherDataRepository(mockwdsfactory, mockmapper);
    }

    @Test
    public void testGetDailyWeather()
    {
        List<DailyWeather> mlist = new ArrayList<>();
        List<DailyWeatherEntity> wlist = new ArrayList<>();

        given(mockwdsfactory.getDataStore()).willReturn(wdstore);
        given(wdstore.getWeatherList()).willReturn(observable.just(wlist));
        given(mockmapper.transform(wlist)).willReturn(mlist);

        Observable<List<DailyWeather>> dw = wdrepo.getDailyWeather();

        verify(mockwdsfactory).getDataStore();
        verify(wdstore).getWeatherList();


        Assert.assertNotNull(dw);
    }
}
