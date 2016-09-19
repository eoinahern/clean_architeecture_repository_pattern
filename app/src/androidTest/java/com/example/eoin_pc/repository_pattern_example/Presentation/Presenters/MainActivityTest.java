package com.example.eoin_pc.repository_pattern_example.Presentation.Presenters;
import android.app.Instrumentation;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.example.eoin_pc.repository_pattern_example.MainActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;


/**
 * Created by eoin_pc on 16/09/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest
{


    MainActivity maiact;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);



    @Before
    public void setup()
    {
       maiact =  mActivityRule.getActivity();
    }


    @Test
    public void testNotNull()
    {
        Assert.assertNotNull(maiact);
    }



}
