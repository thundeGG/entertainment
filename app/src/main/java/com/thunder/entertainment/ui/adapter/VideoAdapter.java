package com.thunder.entertainment.ui.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.ImageLoader;
import com.thunder.entertainment.model.kaiyan.ItemListBean;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/22.
 */

public class VideoAdapter extends BaseMultiItemQuickAdapter<ItemListBean, BaseViewHolder> {

    public final String TAG = this.getClass().getSimpleName();

    private StandardGSYVideoPlayer gsyVideoPlayer;

    public VideoAdapter(List data) {
        super(data);
        addItemType(ItemListBean.TYPE_VIDEO, R.layout.item_video_list);
        addItemType(ItemListBean.TYPE_OTHER, R.layout.item_video_null);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ItemListBean item) {

        switch (helper.getItemViewType()) {
            case ItemListBean.TYPE_VIDEO:

                gsyVideoPlayer = helper.getView(R.id.video_item_player);

                ImageView imageView = new ImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ImageLoader.getInstance().displayImage(mContext, item.getData().getCover().getDetail(), imageView);

                if (imageView.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup)imageView.getParent();
                    viewGroup.removeView(imageView);
                }

                //设置封面
                gsyVideoPlayer.setThumbImageView(imageView);

                String url = item.getData().getPlayUrl();
                String title = item.getData().getTitle();
                gsyVideoPlayer.setUp(url, true, null, title);

                //隐藏标题
                gsyVideoPlayer.getTitleTextView().setVisibility(View.GONE);
                //隐藏返回按钮
                gsyVideoPlayer.getBackButton().setVisibility(View.GONE);
                //设置全屏按键功能
                gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resolveFullBtn(gsyVideoPlayer);
                    }
                });
                gsyVideoPlayer.setRotateViewAuto(true);
                gsyVideoPlayer.setLockLand(false);
                gsyVideoPlayer.setPlayTag(TAG);
                gsyVideoPlayer.setShowFullAnimation(true);
                //不循环
                gsyVideoPlayer.setLooping(false);
                //全屏锁定屏幕功能
                gsyVideoPlayer.setNeedLockFull(true);

                helper.getAdapterPosition();
                gsyVideoPlayer.setPlayPosition(helper.getPosition());
                Log.i(TAG, "position ===========" + helper.getPosition());

                break;
            case ItemListBean.TYPE_OTHER:

                break;
        }
    }


    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(mContext, false, false);
    }
}
