package com.example.eoin_pc.repository_pattern_example.domain.interactor;

import com.example.eoin_pc.repository_pattern_example.domain.WeatherRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by eoin_pc on 09/08/2016.
 * these are esentially the use cases
 */
public class GetWeather  extends UseCase {

    //inject weather repository here
    private WeatherRepository weatherrepo;

    @Inject
    public GetWeather(WeatherRepository weatherrepoin)
    {
        weatherrepo = weatherrepoin;
    }

    @Override
    public Observable buildUseCaseObservable() {
       return  weatherrepo.getDailyWeather();
    }
}
