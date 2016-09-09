package com.example.eoin_pc.repository_pattern_example.Presentation.DI.Modules;

import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components.FragScope;
import com.example.eoin_pc.repository_pattern_example.domain.WeatherRepository;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.GetWeather;
import com.example.eoin_pc.repository_pattern_example.domain.interactor.UseCase;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by eoin_a on 08/09/2016.
 */
@Module
public class FragModule {




    public FragModule()
    {
    }

    @Provides
    @FragScope
    @Named("mainscheduler")
    public Scheduler getMainScheduler()
    {
        return AndroidSchedulers.mainThread();
    }


    @Provides
    @FragScope
    @Named("ioscheduler")
    public Scheduler getIOScheduler()
    {
        return Schedulers.io();
    }


    @Provides
    @FragScope
    @Named("getweather")
    public UseCase getWeatherUsecase(WeatherRepository wrepo, @Named("mainscheduler") Scheduler mainsched,@Named("ioscheduler") Scheduler iosched)
    {
        return new GetWeather(wrepo, mainsched, iosched);
    }
}
