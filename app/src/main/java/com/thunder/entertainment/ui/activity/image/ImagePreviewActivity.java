package com.thunder.entertainment.ui.activity.image;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseActivity;
import com.thunder.entertainment.common.utils.ZoomImageView;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.ui.adapter.ImageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zzr on 2017/6/29.
 */

public class ImagePreviewActivity extends BaseActivity {
    @BindView(R.id.image)
    ZoomImageView mImage;

    public static final String URL_TAG = "URL_TAG";
    public static final String SCALETYPE_TAG = "SCALETYPE_TAG";
    public static final String SCALETYPE_FITXY = "FIT_XY";
    private String SCALETYPE = SCALETYPE_FITXY;
    public static final String SCALETYPE_CENTERCROP = "CENTER_CROP";
    private String url;

    @Override
    protected int getLayoutId() {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        return R.layout.activity_image_preview;
    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.fade);
            //退出时使用
            getWindow().setExitTransition(explode);
            //第一次进入时使用
            getWindow().setEnterTransition(explode);
            //再次进入时使用
            getWindow().setReenterTransition(explode);
        }
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra(URL_TAG);
        SCALETYPE = intent.getStringExtra(SCALETYPE_TAG);

        if (SCALETYPE_FITXY.equals(SCALETYPE)) {
//            image.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (SCALETYPE_CENTERCROP.equals(SCALETYPE)) {
//            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
//            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        ImageLoader.getInstance().loadNet(mImage, url, null);

    }

}
