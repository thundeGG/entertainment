package com.thunder.entertainment.common.base;

/**
 * Created by beibeizhu on 17/6/14.
 */


import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by beiebizhu on 2017/6/2.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */
public class RxPresenter<T> implements BasePresenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
