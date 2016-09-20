package com.example.eoin_pc.repository_pattern_example;

import android.app.Application;
import android.os.Bundle;

import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components.AppComponent;
import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components.DaggerAppComponent;
import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components.DaggerFragComponent;
import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components.FragComponent;
import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Modules.AppModule;

/**
 * Created by eoin_a on 31/08/2016.
 */
public class MyApplication extends Application {

    private AppComponent appcomp;
    private FragComponent fragcomp;

    @Override
    public void onCreate() {
        super.onCreate();

        appcomp = DaggerAppComponent.builder().appModule(new AppModule(this))
                .build();


        fragcomp = DaggerFragComponent.builder().appComponent(appcomp).build();

    }


    public AppComponent getInst()
    {
       return appcomp;
    }


    public FragComponent getFragComponent()
    {
        return fragcomp;
    }

}
