package com.example.eoin_pc.repository_pattern_example.Presentation.Fragments;

import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.List;

/**
 * Created by eoin_pc on 09/09/2016.
 */
public interface WeatherFragView {

    void SetProgress(boolean visible);
    void setUpView(List<DailyWeatherEntity> wlist);
}
