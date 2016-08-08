package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class WeatherDataStoreFactory {




    public WeatherDataStoreFactory()
    {

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
            wdatastore = new DiskWeatherDataStore();

        return wdatastore;
    }



    public WeatherDataStore getDiskDataStore()
    {
        return new DiskWeatherDataStore();
    }


    /**
     * check we can make requests to web
     * @return
     */

    private boolean checkConnected()
    {
        return false;
    }





}
