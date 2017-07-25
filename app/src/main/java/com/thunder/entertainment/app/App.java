package com.thunder.entertainment.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lzy.ninegrid.NineGridView;
import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.common.utils.SPUtils;
import com.thunder.entertainment.common.utils.Utils;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.dao.ChannelManager;
import com.thunder.entertainment.dao.ShapeManager;

import java.util.HashSet;
import java.util.Set;

import entertainment.dao.GreenDaoHelper;

/**
 * Created by zzr on 16/11/15.
 */

public class App extends Application {
    private static App instance;
    private Set<Activity> allActivity;
    private final String TAG = "Entertainment";

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(getApplicationContext());
        SPUtils spUtils = new SPUtils(TAG);
        //初始化RetrofitHelper和OkHttpClient
        RetrofitHelper.getInstance().initOkHttpClient();
        //初始化GreenDao
        GreenDaoHelper.initDatabase();

        ChannelManager.getInstance().initData();
        ShapeManager.getInstance().initData();
//        GlideOptions.initDefaultOptions(R.mipmap.ic_launcher, R.mipmap.ic_launcher);

        NineGridView.setImageLoader(new GlideImageLoader());

    }

    public void registerActivity(Activity activity) {
        if (allActivity == null) {
            allActivity = new HashSet<Activity>();
        }
        allActivity.add(activity);
    }

    public void unreisterActivity(Activity activity) {
        if (allActivity != null) {
            allActivity.remove(activity);
        }
    }

    public void exitApp() {
        if (allActivity != null) {
            synchronized (allActivity) {
                for (Activity activity : allActivity) {
                    if (activity != null && !activity.isFinishing()) {
                        activity.finish();
                    }
                }
            }

        }

    }

    /**
     * Glide 加载
     */
    private class GlideImageLoader implements NineGridView.ImageLoader {

        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            ImageLoader.getInstance().displayImage(context, url, imageView);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }

}
