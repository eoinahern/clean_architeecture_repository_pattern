package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_pc.repository_pattern_example.data.DB.DBQueryExecutor;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.DiskWeatherDataStore;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import rx.Observable;

/**
 * Created by eoin_pc on 22/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class DiskWeatherDataStoreTest {


    private DiskWeatherDataStore dwdatastore;
    private DBQueryExecutor mockdbqexecutor;
    private Observable obs;
    private Context cont;


    @Before
    public void setUp()
    {
        cont = Mockito.mock(Context.class);
        mockdbqexecutor = Mockito.mock(DBQueryExecutor.class);
        obs = Mockito.mock(Observable.class);
        dwdatastore = new DiskWeatherDataStore(cont);
    }


    @Test
    public void testGetWeatherList()
    {
        Observable obs = dwdatastore.getWeatherList();
        Assert.assertNotNull(obs);
        Assert.assertTrue(obs instanceof Observable);
    }
}
