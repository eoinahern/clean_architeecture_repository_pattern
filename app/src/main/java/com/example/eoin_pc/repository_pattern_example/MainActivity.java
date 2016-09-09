package com.example.eoin_pc.repository_pattern_example;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eoin_pc.repository_pattern_example.Presentation.Activities.BaseActivity;
import com.example.eoin_pc.repository_pattern_example.Presentation.Fragments.WeatherFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WeatherFragment frag = WeatherFragment.newInstance();

        FragmentManager fragman = getSupportFragmentManager();
        FragmentTransaction fragtrans = fragman.beginTransaction();
        fragtrans.add(R.id.container, frag);
        fragtrans.commit();
    }
}
