package com.thunder.entertainment.common.net;


import com.thunder.entertainment.BuildConfig;
import com.thunder.entertainment.api.GankService;
import com.thunder.entertainment.api.JuheService;
import com.thunder.entertainment.api.KaiYanService;
import com.thunder.entertainment.app.Constants;
import com.thunder.entertainment.common.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beibeizhu on 16/11/17.
 * <p>
 * 网络请求封装
 */

public class RetrofitHelper {

    //RetrofitHelper静态对象，全局只存在一个
    private static RetrofitHelper INSTANCE = null;
    //网络请求载体
    private OkHttpClient sOkHttpClient = null;
    //干活集中营接口
    private GankService mGankService = null;
    //聚合新闻接口
    private JuheService mJuheService = null;
    //开眼视频接口
    private KaiYanService mKaiYanService = null;

    //缓存最大值
    private final long CACHE_MAX_SIZE = 1024 * 1024 * 50;
    //响应头部的缓存设置
    private final String CACHE_CONTROL = "Cache-Control";
    //有网情况下设置缓存最大时间
    private final int MAX_AGE = 0;
    private final String CACHE_HAS_NTE_MAX_AGE = "public, max-age=";
    //无网情况下设置缓存最大时间
    private final int MAX_STALE = 60 * 60 * 24 * 30;
    private final String CACHE_NOT_NTE_MAX_AGE = "public, only-if-cached, max-stale=";
    //连接超时
    private final int CONNECT_TIME_OUT = 20;
    //读取超时
    private final int READ_TIME_OUT = 20;
    //写入超时
    private final int WRITE_TIME_OUT = 20;

    //私有构造  不允许外部new
    private RetrofitHelper() {
    }

    /**
     * 初始化OkHttpClient
     * 必须先初始化
     */
    public void initOkHttpClient() {
        if (sOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //debug模式下开启OkHttp网络请求日志拦截
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                //记录网络请求信息 
                //BASIC 请求/响应行 
                //HEADER 请求/响应行 + 头 
                //BODY 请求/响应行 + 头 + 体
                //NONE 不记录
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //给OkHttp设置日志拦截
                builder.addInterceptor(loggingInterceptor);
            }
            //网络请求缓存路径
            File  cacheFile = new File(Constants.PATH_NET_CACHE);
            //缓存
            final Cache cache = new Cache(cacheFile, CACHE_MAX_SIZE);
            //拦截器
            Interceptor cacheInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    //获取当前request对象
                    Request request = chain.request();
                    if (!SystemUtils.isNetworkConnected()) {
                        //没有网络仅使用缓存
                        request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                    }
                    int tryCount = 0;//尝试重新连接次数
                    Response response = chain.proceed(request);
                    //如果响应失败  并且尝试连接的次数小于3就重连
                    while (!response.isSuccessful() && tryCount < 3) {
//                        XLog.d("响应失败,正在尝试重连------------->" + tryCount);
                        response = chain.proceed(request);
                        tryCount++;
                    }

                    if (SystemUtils.isNetworkConnected()) {
                        response.newBuilder()
                                .header(CACHE_CONTROL, CACHE_HAS_NTE_MAX_AGE + MAX_AGE);
                    } else {
                        response.newBuilder()
                                .header(CACHE_CONTROL, CACHE_NOT_NTE_MAX_AGE + MAX_STALE);
                    }
                    return response;
                }
            };
            //设置缓存
            builder.addNetworkInterceptor(cacheInterceptor);
            builder.addInterceptor(cacheInterceptor);
            builder.cache(cache);
            //设置超时
            builder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
            builder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS);
            builder.writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);

            sOkHttpClient = builder.build();
        }
    }

    /**
     * 外部获取RetrofitHelper  加个同步锁  保证线程安全
     */
    public static RetrofitHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (RetrofitHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitHelper();
                }
            }
        }
        return INSTANCE;
    }

    public GankService getGankSercice() {
        if (mGankService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(sOkHttpClient)
                    .baseUrl(GankService.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mGankService = retrofit.create(GankService.class);
        }
        return mGankService;
    }

    public JuheService getJuheSercice() {
        if (mJuheService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(sOkHttpClient)
                    .baseUrl(JuheService.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mJuheService = retrofit.create(JuheService.class);
        }
        return mJuheService;
    }

    public KaiYanService getKaiYanService(){
        if (mKaiYanService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(sOkHttpClient)
                    .baseUrl(KaiYanService.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mKaiYanService = retrofit.create(KaiYanService.class);
        }
        return mKaiYanService;
    }
}
