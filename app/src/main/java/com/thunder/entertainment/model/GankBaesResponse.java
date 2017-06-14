package com.thunder.entertainment.model;

/**
 * Created by beibeizhu on 16/11/17.
 */

public class GankBaesResponse<T> {

    //请求是否出错
    private boolean error;
    //请求成功的结果
    private T results;

    public boolean isError() {
        return error;
    }

    public GankBaesResponse setError(boolean error) {
        this.error = error;
        return this;
    }

    public T getResults() {
        return results;
    }

    public GankBaesResponse setResults(T results) {
        this.results = results;
        return this;
    }
}
