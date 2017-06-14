package com.thunder.entertainment.common.base;

/**
 * Created by beibeizhu on 17/6/14.
 */

public abstract class BaseData<T> {
    private int code;
    private String msg;
    private T data;

    public boolean isSuccess(){
        return getCode();
    }
    
    public String getMessage(){
        return getMsg();
    }

    protected abstract String getMsg();

    protected abstract boolean getCode();

}
