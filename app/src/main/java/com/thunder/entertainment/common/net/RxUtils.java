package com.thunder.entertainment.common.net;

import com.zz.treless.model.bean.GankBaesResponse;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.zz.treless.app.Constants.EXCEPTION_API;

/**
 * Created by beibeizhu on 16/11/21.
 * <p>
 * rx工具类
 */

public class RxUtils {

    /**
     * 线程调度器
     */
    public static <T> Observable.Transformer<T, T> threadSwitcher() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable.Transformer<GankBaesResponse<T>, T> handlerResult() {
        return new Observable.Transformer<GankBaesResponse<T>, T>() {
            @Override
            public Observable<T> call(Observable<GankBaesResponse<T>> gankBaesResponseObservable) {
                return gankBaesResponseObservable.flatMap(new Func1<GankBaesResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(GankBaesResponse<T> tGankBaesResponse) {
                        if (!tGankBaesResponse.isError()) {
                            return createData(tGankBaesResponse.getResults());
                        } else {
                            return Observable.error(new ApiException(EXCEPTION_API));
                        }
                    }
                });
            }
        };
    }

    /**
     * 获取数据  并切换线程
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.onNext(t);
                subscriber.onCompleted();
            }
        });
    }
}
