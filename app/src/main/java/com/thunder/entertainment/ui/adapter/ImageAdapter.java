package com.thunder.entertainment.ui.adapter;

import android.support.annotation.LayoutRes;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.imageutil.GlideOptions;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.model.GankModel;

/**
 * Created by beibeizhu on 17/6/16.
 */

public class ImageAdapter extends BaseQuickAdapter<GankModel, BaseViewHolder> {
    public ImageAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankModel item) {
        ImageLoader.getInstance().loadNet((ImageView) helper.getView(R.id.iv_imgs), item.getUrl(),
                new GlideOptions(R.drawable.ic_image, R.drawable.ic_image, 2, 20));
    }
}
