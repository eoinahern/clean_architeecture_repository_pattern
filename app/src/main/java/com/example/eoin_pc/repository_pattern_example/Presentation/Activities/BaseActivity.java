package com.example.eoin_pc.repository_pattern_example.Presentation.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eoin_pc.repository_pattern_example.MyApplication;
import com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components.AppComponent;

public class BaseActivity extends AppCompatActivity {


    protected AppComponent appcomponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    protected AppComponent getAppComponent()
    {
        return appcomponent;
    }
}
