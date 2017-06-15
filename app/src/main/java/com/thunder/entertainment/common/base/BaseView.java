package com.thunder.entertainment.common.base;

/**
 * Created by beibeizhu on 17/6/12.
 */

public interface BaseView<T> {
    //设置业务处理者
    void setPresenter(T presenter);
}
