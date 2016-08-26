package com.example.eoin_pc.repository_pattern_example.data.Web;

import android.content.res.Resources;
import android.util.Log;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class RestAPICallsImp  {

    private String BASE_URL =  "https://api.forecast.io/forecast/63f0914cdd082e76d25b40161cbe70c4";
    private  Retrofit retrofit;
    private RestAPICalls restapicalls;


    public RestAPICallsImp()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restapicalls = retrofit.create(RestAPICalls.class);
    }


    public Observable<List<DailyWeatherEntity>> getWeatherList() {

        Call call = restapicalls.getDailyWeather(53.3441, -6.2675);
        return Observable.create(subscriber -> {

            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        subscriber.onNext((List<DailyWeatherEntity>) response.body());
                        subscriber.onCompleted();
                    } else {
                        subscriber.onError(new Resources.NotFoundException());
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    subscriber.onError(new Resources.NotFoundException());
                }
            });
        });


    }

}
