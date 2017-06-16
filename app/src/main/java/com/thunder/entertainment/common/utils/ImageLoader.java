package com.thunder.entertainment.common.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.thunder.entertainment.R;

/**
 * Created by beibeizhu on 17/6/16.
 */

public class ImageLoader {

    private static ImageLoader instance = null;

    private ImageLoader(){

    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class){
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    public void displayImage(Context context,String url, ImageView imageView) {
        displayImage(context,url,R.drawable.image_loading,R.drawable.image_loading,imageView);
    }

    public void displayImage(Context context,String url,int placeHolder,int error, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .placeholder(placeHolder)
                .error(error)
                .into(imageView);
    }


}
