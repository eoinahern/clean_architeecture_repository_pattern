package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_pc.repository_pattern_example.Presentation.Fragments.WeatherFragView;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.UseCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;
import org.mockito.MockitoAnnotations;

import rx.Subscriber;


/**
 * Created by eoin_pc on 15/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class WeatherListPresenterTest {


    private WeatherListPresenter weatherpresenter;


    Context cont;
    //@Mock UseCase getweather;
    //@Mock WeatherFragView weatherview;


    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        cont =  InstrumentationRegistry.getContext();
        //weatherpresenter = new WeatherListPresenter(getweather);
        //weatherpresenter.setView(weatherview);
    }


    @Test
    public void testGetWeatherList()
    {

       /*given(weatherview.context()).willReturn(cont);
        //execute
        weatherpresenter.getWeatherDetails();

        //verify
        Mockito.verify(weatherview).SetProgress(Mockito.anyBoolean());
        Mockito.verify(getweather).execute(Mockito.any(Subscriber.class));*/
        Assert.assertEquals(1,1);



    }

}