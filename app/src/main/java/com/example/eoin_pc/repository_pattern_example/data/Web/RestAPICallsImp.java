package com.example.eoin_pc.repository_pattern_example.data.Web;

import android.util.Log;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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


    public void getWeatherList()
    {
        Call call =  restapicalls.getDailyWeather(53.3441,-6.2675);


        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {


                if(response.isSuccessful())
                {
                    //send data back
                    ArrayList<DailyWeatherEntity> weather = (ArrayList<DailyWeatherEntity>) response.body();
                    Log.d("weather", weather.toString());
                }
                else
                {
                   //failed message!!!
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                //return failure
            }
        });
    }

}
