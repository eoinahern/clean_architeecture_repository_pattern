package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;

import android.util.Log;

import com.example.eoin_pc.repository_pattern_example.Presentation.Fragments.WeatherFragView;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;
import com.example.eoin_pc.repository_pattern_example.domain.DailyWeather;
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


    public void destroy()
    {
        getweatherusecase.unsubscribe();
        weatherview = null;
    }

    public void getWeatherDetails()
    {
        Log.d("get weather", "get weather");
        weatherview.SetProgress(true);
        getweatherusecase.execute(new WeatherSubscriber());
    }

    class WeatherSubscriber extends Subscriber<List<DailyWeather>>
    {
        @Override
        public void onCompleted()
        {
            weatherview.SetProgress(false);
        }

        @Override
        public void onError(Throwable e) {
            // show error in the view

            Log.d("error", "error in subscriber!");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        @Override
        public void onNext(List<DailyWeather> dailyWeatherEntities) {
            Log.d("weather len", String.valueOf(dailyWeatherEntities.size()));
            weatherview.setUpView(dailyWeatherEntities);
        }
    }
}
