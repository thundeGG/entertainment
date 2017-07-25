package com.thunder.entertainment.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;

/**
 * Created by beibeizhu on 17/7/19.
 */

public class ShapeImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ShapeImageAdapter() {
        super(R.layout.item_shape_image);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.img_pic_del);

       ImageView imageView =  helper.getView(R.id.img_pic);
        int width = imageView.getWidth();
        imageView.setMaxHeight(width);
        ImageLoader.getInstance().displayImage(mContext,"file://"+item, imageView);
    }
}
