package com.thunder.entertainment.ui.viewrouter;

import android.app.Activity;
import android.app.ActivityOptions;

import com.thunder.entertainment.R;
import com.thunder.entertainment.common.router.Router;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.ui.activity.image.ImagePreviewActivity;

/**
 * Created by zzr
 */
public class UrlRouter {

    private static UrlRouter instance = null;

    private UrlRouter() {

    }

    public static UrlRouter getInstance() {
        if (instance == null) {
            synchronized (UrlRouter.class) {
                if (instance == null) {
                    instance = new UrlRouter();
                }
            }
        }
        return instance;
    }

    public void goImagePreViewActivity(Activity activity, String imgurl) {
        Router.newIntent().from(activity).to(ImagePreviewActivity.class)
                .putString(ImagePreviewActivity.URL_TAG, imgurl)
                .launch();
    }
}
