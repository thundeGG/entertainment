package com.thunder.entertainment.api;

import com.thunder.entertainment.model.kaiyan.VideoListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface KaiYanService {
    public final String BASE_URL = "https://baobab.kaiyanapp.com/api/v4/";

    @GET("tabs/selected")
    Observable<VideoListBean> getVideoList(@Query("date") String date);
}
