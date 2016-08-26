package com.example.eoin_pc.repository_pattern_example.data.repository.datasource;

import android.content.res.Resources;
import android.util.Log;

import com.example.eoin_pc.repository_pattern_example.data.Web.RestAPICalls;
import com.example.eoin_pc.repository_pattern_example.data.Web.RestAPICallsImp;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public class CloudWeatherDataStore implements WeatherDataStore {

    //use mapper here
    private RestAPICallsImp restcalls;

    public CloudWeatherDataStore()
    {
        restcalls = new RestAPICallsImp();
    }

    @Override
    public Observable<List<DailyWeatherEntity>> getWeatherList() {
        return restcalls.getWeatherList();
    }

    @Override
    public void saveWeatherData(Observable<List<DailyWeatherEntity>> dailyw) {
            throw new UnsupportedOperationException();
    }
}
