package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import com.example.eoin_pc.repository_pattern_example.Presentation.Fragments.WeatherFragView;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.GetWeather;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.UseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by eoin_a on 06/09/2016.
 */
public class WeatherListPresenter implements Presenter {

    private UseCase getweatherusecase;
    private WeatherFragView weatherview;

    @Inject
    public WeatherListPresenter(@Named("getweather") UseCase getweather)
    {
        getweatherusecase = getweather;
    }


    public void setView(WeatherFragView weatherviewin)
    {
        weatherview = weatherviewin;
    }

    public void getWeatherDetails()
    {
        getweatherusecase.execute(new WeatherSubscriber());
    }

    class WeatherSubscriber extends Subscriber<List<DailyWeatherEntity>>
    {
        @Override
        public void onCompleted()
        {
            weatherview.SetProgress(false);
        }

        @Override
        public void onError(Throwable e) {
            // show error in the view
        }

        @Override
        public void onNext(List<DailyWeatherEntity> dailyWeatherEntities) {
            weatherview.setUpView(dailyWeatherEntities);
        }
    }
}
