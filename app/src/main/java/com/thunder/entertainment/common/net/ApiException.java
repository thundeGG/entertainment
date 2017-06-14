package com.thunder.entertainment.common.net;

/**
 * Created by beibeizhu on 16/11/21.
 *
 * api请求异常
 */

public class ApiException extends Exception {

    public ApiException(String msg) {
        super(msg);
    }
}
