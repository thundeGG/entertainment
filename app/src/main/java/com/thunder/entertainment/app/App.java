package com.thunder.entertainment.app;

import android.app.Activity;
import android.app.Application;

import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.common.utils.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zzr on 16/11/15.
 */

public class App extends Application {
    private static App instance;
    private Set<Activity> allActivity;
    private final String TAG = "Treless";

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
;        instance = this;
        Utils.init(getApplicationContext());
        //初始化RetrofitHelper和OkHttpClient
        RetrofitHelper.getInstance().initOkHttpClient();
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
