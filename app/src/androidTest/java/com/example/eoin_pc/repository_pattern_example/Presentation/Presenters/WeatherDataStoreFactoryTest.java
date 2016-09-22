package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_pc.repository_pattern_example.MyApplication;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataStore;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataStoreFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
    private MyApplication app;


    @Before
    public void setUp()
    {
        cont  = mock(Context.class);
        mockconmanager = mock(ConnectivityManager.class);
        app = mock(MyApplication.class);
        networkinfo = mock(NetworkInfo.class);


        given(cont.getApplicationContext()).willReturn(app);
        wdstorefactory = new WeatherDataStoreFactory(cont);
    }


    @Test
    public void testgetDataStore()
    {
        when(app.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockconmanager);
        when(mockconmanager.getActiveNetworkInfo()).thenReturn(networkinfo);
        when(networkinfo.isConnected()).thenReturn(true);


        WeatherDataStore wds = wdstorefactory.getDataStore();


        verify(app).getSystemService(Context.CONNECTIVITY_SERVICE);
        verify(mockconmanager).getActiveNetworkInfo();
        verify(networkinfo).isConnected();

        Assert.assertNotNull(wds);
    }

    @Test
    public void testGetDiskDataStore()
    {
        Assert.assertNotNull(wdstorefactory.getDiskDataStore());
    }
}
