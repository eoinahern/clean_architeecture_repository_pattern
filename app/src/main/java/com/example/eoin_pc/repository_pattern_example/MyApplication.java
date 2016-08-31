package com.example.eoin_pc.repository_pattern_example;

import android.app.Application;
import android.os.Bundle;

/**
 * Created by eoin_a on 31/08/2016.
 */
public class MyApplication extends Application {


    private static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }


    public static MyApplication getInst()
    {
        return app;
    }

}
