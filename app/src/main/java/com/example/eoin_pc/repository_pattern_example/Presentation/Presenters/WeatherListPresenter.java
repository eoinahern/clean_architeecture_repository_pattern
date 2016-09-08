package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import com.example.eoin_pc.repository_pattern_example.domain.interactor.GetWeather;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.UseCase;

import javax.inject.Inject;

/**
 * Created by eoin_a on 06/09/2016.
 */
public class WeatherListPresenter implements Presenter {


    // in the presenter we need the use case tp carry out
    // and the subscriber to get the data
    // also the view interface.
    //we the inject presenter into our view/fragment
    private UseCase getweatherusecase;


    //inject usecase
    @Inject
    public WeatherListPresenter(UseCase getweather)
    {
        getweatherusecase = getweather;
    }


    public void setView()
    {


    }




}
