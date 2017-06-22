package com.thunder.entertainment.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.DateUtils;
import com.thunder.entertainment.common.utils.ImageLoader;
import com.thunder.entertainment.model.kaiyan.ItemListBean;

/**
 * Created by beibeizhu on 17/6/22.
 */

public class VideoAdapter extends BaseQuickAdapter<ItemListBean, BaseViewHolder> {

    public VideoAdapter() {
        super(R.layout.item_video_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemListBean item) {

        String category = item.getData().getCategory();
        String time = DateUtils.formatTime2(item.getData().getDate());


        ImageLoader.getInstance().displayImage(mContext, item.getData().getCover().getDetail(), (ImageView) helper.getView(R.id.img_video_image));

        helper.setText(R.id.tv_video_title, item.getData().getTitle())
                .setText(R.id.tv_video_info, "#" + category + " / " + time);
    }
}
