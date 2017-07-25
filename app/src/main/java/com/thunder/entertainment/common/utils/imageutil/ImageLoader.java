package com.thunder.entertainment.common.utils.imageutil;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.thunder.entertainment.R;

import java.io.File;

/**
 * Created by beibeizhu on 17/6/16.
 */

public class ImageLoader {

    private static ImageLoader instance = null;

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    public void displayImage(Context context, String url, ImageView imageView) {
        displayImage(context, url, R.drawable.image_loading, R.drawable.image_loading, imageView);
    }

    public void displayImage(Context context, String url, int placeHolder, int error, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .placeholder(placeHolder)
                .error(error)
                .into(imageView);
    }

    public void displayImageNormal(Context context, String url, int placeHolder, int error, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(placeHolder)
                .error(error)
                .into(imageView);
    }

    /**
     * 网络获取图片
     *
     * @param target
     * @param url
     * @param options
     */
    public void loadNet(ImageView target, String url, GlideOptions options) {
        loadImage(getRequestManager(target.getContext()).load(url), target, options);
    }

    /**
     * 资源图片
     *
     * @param target
     * @param resId
     * @param options
     */
    public void loadResource(ImageView target, int resId, GlideOptions options) {
        loadImage(getRequestManager(target.getContext()).load(resId), target, options);
    }

    /**
     * 本地asset图片
     *
     * @param target
     * @param assetName
     * @param options
     */
    public void loadAssets(ImageView target, String assetName, GlideOptions options) {
        loadImage(getRequestManager(target.getContext()).load("file:///android_asset/" + assetName), target, options);
    }

    /**
     * 文件加载
     *
     * @param target
     * @param file
     * @param options
     */
    public void loadFile(ImageView target, File file, GlideOptions options) {
        loadImage(getRequestManager(target.getContext()).load(file), target, options);
    }

    /**
     * 清除内存缓存
     *
     * @param context
     */
    public void clearMemoryCache(Context context) {
        Glide.get(context).clearMemory();
    }

    /**
     * 清除磁盘缓存
     *
     * @param context
     */
    public void clearDiskCache(Context context) {
        Glide.get(context).clearDiskCache();
    }

    private RequestManager getRequestManager(Context context) {
        if (context instanceof Activity) {
            return Glide.with((Activity) context);
        }
        return Glide.with(context);
    }


    private void loadImage(DrawableTypeRequest request, ImageView target, GlideOptions options) {
        if (options == null) options = GlideOptions.defaultOptions();

        if (options.loadingResId != GlideOptions.RES_NONE) {
            request.placeholder(options.loadingResId);
        }
        if (options.loadErrorResId != GlideOptions.RES_NONE) {
            request.error(options.loadErrorResId);
        }
        if (options.circleType != GlideOptions.RES_NONE) {
            if (options.circleType == GlideOptions.CIRCLE) {
                request.transform(new GlideCircleTransform(target.getContext()));
            } else if (options.circleType == GlideOptions.ROUND) {
                request.transform(new GlideRoundTransform(target.getContext(), options.angle));
            }
        }

        request.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .crossFade()
                .into(target);

    }

}
