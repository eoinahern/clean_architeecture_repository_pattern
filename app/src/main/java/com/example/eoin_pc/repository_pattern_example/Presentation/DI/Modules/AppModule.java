package com.example.eoin_pc.repository_pattern_example.Presentation.DI.Modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.eoin_pc.repository_pattern_example.MyApplication;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataRepository;
import com.example.eoin_pc.repository_pattern_example.domain.WeatherRepository;

import android.preference.PreferenceManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by eoin_a on 31/08/2016.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application appin)
    {
        application = appin;
    }

    @Provides
    @Singleton
    @Named("cont")
    public Context getCont()
    {
        return  application;
    }


    @Provides
    @Singleton
    public SharedPreferences getPrefs()
    {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }



    @Provides
    @Singleton
    public WeatherRepository getRepository(WeatherDataRepository wdr)
    {
        return wdr;
    }




}
