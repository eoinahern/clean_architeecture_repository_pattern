package com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components;

import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Modules.FragModule;
import com.example.eoin_pc.repository_pattern_example.Presentation.Fragments.WeatherFragment;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by eoin_a on 08/09/2016.
 */
@FragScope
@Component(dependencies = AppComponent.class , modules = {FragModule.class})
public interface FragComponent {

    void inject(WeatherFragment wfrag);
}
