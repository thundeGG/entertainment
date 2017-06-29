package com.thunder.entertainment.api;

import com.thunder.entertainment.model.GankBaesResponse;
import com.thunder.entertainment.model.GankModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface GankService {

    //gank 接口前缀
    public final String BASE_URL = "http://gank.io/api/";

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     */
    @GET("data/{type}/{count}/{page}")
    public Observable<GankBaesResponse<List<GankModel>>> getGankNews(@Path("type") String type, @Path("count") int count, @Path("page") int page);

    @GET("data/{type}/{count}/{page}")
    public Observable<GankBaesResponse<List<GankModel>>> getGankImage(@Path("type") String type, @Path("count") int count, @Path("page") int page);


}
