package com.thunder.entertainment.ui.adapter;

import android.content.pm.ActivityInfo;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.DateUtils;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.model.kaiyan.ItemListBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by beibeizhu on 17/6/22.
 */

public class JieCaoVideoAdapter extends BaseMultiItemQuickAdapter<ItemListBean, BaseViewHolder> {

    public JieCaoVideoAdapter(List data) {
        super(data);
        addItemType(ItemListBean.TYPE_VIDEO, R.layout.item_video_list_jiecao);
        addItemType(ItemListBean.TYPE_OTHER, R.layout.item_video_null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ItemListBean item) {

        switch (helper.getItemViewType()) {
            case ItemListBean.TYPE_VIDEO:

                String url = item.getData().getPlayUrl();
                Log.i(TAG, "convert: "+url);
                String title = item.getData().getTitle();
                long date = item.getData().getDuration();
                Log.i(TAG, "convert: "+date);
                JCVideoPlayerStandard jcVideoPlayerStandard = helper.getView(R.id.videoplayer);
                jcVideoPlayerStandard.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, title);
                jcVideoPlayerStandard.ACTION_BAR_EXIST = false;
                jcVideoPlayerStandard.TOOL_BAR_EXIST = false;
                JCVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                JCVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                ImageView imageView = jcVideoPlayerStandard.thumbImageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageLoader.getInstance().displayImage(mContext, item.getData().getCover().getDetail(), imageView);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("#").append(item.getData().getCategory())
                        .append(" ")
                        .append(" / ")
                        .append(" ")
                        .append(DateUtils.formatTime2(item.getData().getDuration()));
                helper.setText(R.id.tv_video_info, stringBuilder.toString());

                helper.addOnClickListener(R.id.ll_video_info)
                        .addOnClickListener(R.id.tv_guanzhu)
                        .addOnClickListener(R.id.tv_pinglun)
                        .addOnClickListener(R.id.img_more);
                break;
            case ItemListBean.TYPE_OTHER:

                break;
        }
    }

}
