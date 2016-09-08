package com.example.eoin_pc.repository_pattern_example.domain;

/**
 * Created by eoin_pc on 08/09/2016.
 */


import com.example.eoin_pc.repository_pattern_example.domain.interactor.UseCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.Subscriber;
import rx.observers.TestSubscriber;

public class UseCaseTest {


    private UseCaseTestClass useCase;

    @Mock TestSubscriber testsub;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.useCase = new UseCaseTestClass();
    }


    @Test
    public void testExecute()
    {

        //cant  use android.mainthread in testing observables!!!
        /*TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        useCase.execute(testsub);
        Assert.assertEquals(testSubscriber.getOnErrorEvents().size(), 0);*/

    }
















    private static class UseCaseTestClass extends UseCase {

        protected UseCaseTestClass()
        {

        }

        @Override protected Observable buildUseCaseObservable() {
            return Observable.empty();
        }

        @Override public void execute(Subscriber UseCaseSubscriber) {
            super.execute(UseCaseSubscriber);
        }
    }


}
