package com.thunder.entertainment.common.base;

/**
 * Created by beibeizhu on 17/6/12.
 */

public interface BasePresenter<T> {

    //绑定
    void attachView(T view);
    //解绑
    void detachView();
}
