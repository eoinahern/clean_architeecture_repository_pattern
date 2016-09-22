package com.example.eoin_pc.repository_pattern_example.data.Web;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public interface RestAPICalls {


    @GET("{lat},{lon}")
    Call<List<DailyWeatherEntity>> getDailyWeather(@Path("lat") String lat, @Path("lon") String longit);
}
