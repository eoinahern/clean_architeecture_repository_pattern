package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataStoreFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by eoin_pc on 20/09/2016.
 */

@RunWith(AndroidJUnit4.class)
public class WeatherDataStoreFactoryTest {



    private WeatherDataStoreFactory wdstorefactory;
    private Context cont;
    private ConnectivityManager mockconmanager;
    private NetworkInfo networkinfo;


    @Before
    public void setUp()
    {
        cont  = mock(Context.class);
        mockconmanager = mock(ConnectivityManager.class);
        networkinfo = mock(NetworkInfo.class);

        wdstorefactory = new WeatherDataStoreFactory(cont);

    }


    @Test
    public void testgetDataStore()
    {

        given(cont.getSystemService(Context.CONNECTIVITY_SERVICE)).willReturn(mockconmanager);
        given(mockconmanager.getActiveNetworkInfo()).willReturn(networkinfo);

        Assert.assertNotNull(wdstorefactory.getDataStore());
    }
}
