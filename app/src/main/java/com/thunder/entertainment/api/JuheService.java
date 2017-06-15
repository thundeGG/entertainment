package com.thunder.entertainment.api;

import com.thunder.entertainment.model.NewsModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface JuheService {
    public final String BASE_URL = "http://v.juhe.cn/";

    @GET("toutiao/index")
    public Observable<NewsModel> getNews(@Query("type") String type, @Query("key") String key, @Query("start") int start);
}
