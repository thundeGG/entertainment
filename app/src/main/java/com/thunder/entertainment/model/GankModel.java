package com.thunder.entertainment.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by beibeizhu on 16/11/17.
 */

public class GankModel implements Serializable {

    /**
     * _id : 582bc1b4421aa93a61577f2f
     * createdAt : 2016-11-16T10:17:24.383Z
     * desc : Android 画板 View，随心所欲的画画。
     * images : ["http://img.gank.io/fc1b996a-228c-4553-8cb5-159c046a4531"]
     * publishedAt : 2016-11-16T11:37:18.947Z
     * source : chrome
     * type : Android
     * url : https://github.com/ByoxCode/DrawView
     * used : true
     * who : 代码家
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
