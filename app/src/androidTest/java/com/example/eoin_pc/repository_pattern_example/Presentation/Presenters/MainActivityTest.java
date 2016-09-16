package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.example.eoin_pc.repository_pattern_example.MainActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;




/**
 * Created by eoin_pc on 16/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest
{

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void test()
    {

    }


}
