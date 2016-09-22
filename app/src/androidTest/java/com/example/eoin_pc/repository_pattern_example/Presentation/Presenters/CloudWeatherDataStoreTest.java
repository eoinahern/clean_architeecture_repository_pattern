package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.CloudWeatherDataStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;

/**
 * Created by eoin_pc on 22/09/2016.
 */

@RunWith(AndroidJUnit4.class)
public class CloudWeatherDataStoreTest {



    private CloudWeatherDataStore cdstore;
    @Before
    public void setUp()
    {
        cdstore = new CloudWeatherDataStore();
    }


    @Test
    public void testGetWeatherList()
    {
        Observable obs = cdstore.getWeatherList();
        Assert.assertNotNull(obs);
        Assert.assertTrue(obs instanceof Observable);
    }
}
