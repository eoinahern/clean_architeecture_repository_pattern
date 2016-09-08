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
import rx.Scheduler;
import rx.Subscriber;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

public class UseCaseTest {


    private UseCaseTestClass useCase;

    @Mock TestSubscriber testsub;
    @Mock Scheduler mockmainscheduler;
    @Mock Scheduler mockioscheduler;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.useCase = new UseCaseTestClass(mockioscheduler, mockioscheduler);
    }

    @Test
    public void testExecute()
    {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        useCase.execute(testSubscriber);
        useCase.unsubscribe();
        assertThat(testSubscriber.isUnsubscribed(), is(true));

    }


    private static class UseCaseTestClass extends UseCase {

        protected UseCaseTestClass(Scheduler mainshceduler, Scheduler ioscheduler)
        {
            super(mainshceduler, ioscheduler);
        }

        @Override protected Observable buildUseCaseObservable() {
            return Observable.empty();
        }

        @Override public void execute(Subscriber UseCaseSubscriber) {
            super.execute(UseCaseSubscriber);
        }
    }


}
