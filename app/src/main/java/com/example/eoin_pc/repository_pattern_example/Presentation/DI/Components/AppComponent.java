package com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by eoin_a on 31/08/2016.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getCont();
    SharedPreferences getPrefs();
}
