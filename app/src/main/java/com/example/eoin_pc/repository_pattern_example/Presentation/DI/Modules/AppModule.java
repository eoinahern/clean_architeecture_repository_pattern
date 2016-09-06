package com.example.eoin_pc.repository_pattern_example.Presentation.DI.Modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.eoin_pc.repository_pattern_example.MyApplication;
import com.example.eoin_pc.repository_pattern_example.data.repository.datasource.WeatherDataRepository;
import com.example.eoin_pc.repository_pattern_example.domain.WeatherRepository;

import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    public WeatherRepository getRepository(Context cont)
    {
        return new WeatherDataRepository(cont);
    }


}
