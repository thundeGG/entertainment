package com.thunder.entertainment.ui.viewrouter;

import android.app.Activity;

import com.thunder.entertainment.common.router.Router;
import com.thunder.entertainment.model.kaiyan.ItemListBean;
import com.thunder.entertainment.ui.activity.image.ImagePreviewActivity;
import com.thunder.entertainment.ui.activity.video.VideoDetailActivity;

/**
 * Created by zzr
 */
public class UrlRouter {

    private static UrlRouter instance = null;
    private static String URL_VIDEO_DETAIL = "url_video_detail";

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

    public void goVideoDetailActivity(Activity activity, ItemListBean itemListBean) {
        Router.newIntent().from(activity).to(VideoDetailActivity.class)
                .putParcelable("item",itemListBean)
                .launch();
    }
}
