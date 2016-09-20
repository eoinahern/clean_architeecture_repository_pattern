package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by eoin_pc on 08/08/2016.
 */
@Singleton
public class WeatherDataStoreFactory {

    //injects cont into factory in example ive seen!!!
    private Context cont;


    @Inject
    public WeatherDataStoreFactory(Context context)
    {
        cont = context.getApplicationContext();
    }


    /**
     *  get Correct datastore
     * @return WeatherDataStore
     */

    public WeatherDataStore getDataStore()
    {
        WeatherDataStore wdatastore;

        if(checkConnected() == true)
            wdatastore = new CloudWeatherDataStore();
        else
            wdatastore = new DiskWeatherDataStore(cont);

        return wdatastore;
    }



    public WeatherDataStore getDiskDataStore()
    {
        return new DiskWeatherDataStore(cont);
    }


    /**
     * check we can make requests to web
     * @return
     */

    public boolean checkConnected()
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) cont.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }





}
