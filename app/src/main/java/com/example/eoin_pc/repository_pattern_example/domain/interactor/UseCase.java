package com.example.eoin_pc.repository_pattern_example.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by eoin_a on 06/09/2016.
 */
public abstract class UseCase {

    private Subscription subscription = Subscriptions.empty();

    protected Scheduler mainscheduler;
    protected Scheduler ioscheduler;


    public UseCase(Scheduler mainschedulerin, Scheduler ioschedulerin)
    {
        mainscheduler = mainschedulerin;
        ioscheduler = ioschedulerin;
    }

    protected abstract Observable buildUseCaseObservable();

    /**
     * just creating scheulders here. different
     * in implementtion i copied.
     * @param useCaseSubscriber passed from presenter
     */

    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(ioscheduler)
                .observeOn(mainscheduler)
                .subscribe(useCaseSubscriber);
    }


    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
