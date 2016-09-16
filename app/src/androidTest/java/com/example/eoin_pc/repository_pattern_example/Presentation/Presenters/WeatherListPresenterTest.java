package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_pc.repository_pattern_example.Presentation.Fragments.WeatherFragView;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.UseCase;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


import rx.Subscriber;
import rx.observers.TestSubscriber;


/**
 * Created by eoin_pc on 15/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class WeatherListPresenterTest {


    private WeatherListPresenter weatherpresenter;
    private Context cont;
    private  UseCase mockgetweather;
    private WeatherFragView mockweatherview;
    private TestSubscriber testSubscriber;


    @Before
    public void setUp()
    {
       // MockitoAnnotations.initMocks(this); null pointer thrown here?
        
        mockweatherview = mock(WeatherFragView.class);
        mockgetweather = mock(UseCase.class);
        testSubscriber = mock(TestSubscriber.class);
        cont =  InstrumentationRegistry.getContext();
        weatherpresenter = new WeatherListPresenter(mockgetweather);
        weatherpresenter.setView(mockweatherview);
    }


    @Test
    public void testGetWeatherList()
    {
        given(mockweatherview.context()).willReturn(cont);

        //execute
        weatherpresenter.getWeatherDetails();
        Mockito.verify(mockgetweather).execute(Mockito.any(Subscriber.class));
    }

}