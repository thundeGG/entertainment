package com.thunder.entertainment.common.utils.imageutil;

import android.widget.ImageView;

/**
 * Created by zzr on 2017/6/28.
 */

public class GlideOptions {
    public int loadingResId = -1;        //加载中的资源id
    public int loadErrorResId = -1;      //加载失败的资源id
    public static final int RES_NONE = -1;
    public static final int CIRCLE = 1;
    public static final int ROUND = 2;
    public int circleType = RES_NONE;          //1圆形2圆角
    public int angle = RES_NONE;               //角度
    private static GlideOptions defOptions;
    public ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;

    /**
     * 初始化默认图
     *
     * @param loadingResId
     * @param loadErrorResId
     */
    public static void initDefaultOptions(int loadingResId, int loadErrorResId) {
        defOptions = new GlideOptions(loadingResId, loadErrorResId);
    }

    public GlideOptions(int loadingResId, int loadErrorResId) {
        this.loadingResId = loadingResId;
        this.loadErrorResId = loadErrorResId;

    }

    public GlideOptions(int loadingResId, int loadErrorResId, int circleType, int angle) {
        this.loadingResId = loadingResId;
        this.loadErrorResId = loadErrorResId;
        this.circleType = circleType;
        this.angle = angle;
    }


    public static GlideOptions defaultOptions() {
        if (defOptions == null)
            defOptions = new GlideOptions(RES_NONE, RES_NONE, RES_NONE, RES_NONE);
        return defOptions;
    }

}
