package com.thunder.entertainment.app;

import android.app.Activity;
import android.app.Application;

import com.thunder.entertainment.R;
import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.common.utils.SPUtils;
import com.thunder.entertainment.common.utils.Utils;
import com.thunder.entertainment.common.utils.imageutil.GlideOptions;
import com.thunder.entertainment.dao.ChannelManager;

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
//        GlideOptions.initDefaultOptions(R.mipmap.ic_launcher, R.mipmap.ic_launcher);
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
}
