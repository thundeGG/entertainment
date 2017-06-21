package com.thunder.entertainment.common.event;

/**
 * Created by beibeizhu on 17/6/20.
 */

public class MessageEvent<T> {
    private String tag;
    private int position;
    private T data;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
