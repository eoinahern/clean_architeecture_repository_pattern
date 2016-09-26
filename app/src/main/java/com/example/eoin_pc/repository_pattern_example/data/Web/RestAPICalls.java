package com.example.eoin_pc.repository_pattern_example.data.Web;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntityList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by eoin_pc on 08/08/2016.
 */
public interface RestAPICalls {


    @GET("{lat},{lon}")
    Observable<DailyWeatherEntityList> getDailyWeather(@Path("lat") String lat, @Path("lon") String longit);
}
