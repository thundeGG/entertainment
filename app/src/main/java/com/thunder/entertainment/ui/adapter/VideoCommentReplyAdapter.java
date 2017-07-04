package com.thunder.entertainment.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.imageutil.GlideOptions;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.model.CommentReplyModel;

/**
 * Created by beibeizhu on 17/7/4.
 */

public class VideoCommentReplyAdapter extends BaseQuickAdapter<CommentReplyModel, BaseViewHolder> {
    public VideoCommentReplyAdapter() {
        super(R.layout.item_video_comment_reply);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentReplyModel item) {


        helper.setText(R.id.tv_comment_name, item.getName())
                .setText(R.id.tv_comment_zan_num, item.getNum())
                .setText(R.id.tv_comment_content, item.getContent())
                .setText(R.id.tv_comment_date, item.getDate());

        ImageLoader.getInstance().loadNet((ImageView) helper.getView(R.id.img_comment_url), item.getUrl(),
                new GlideOptions(R.drawable.ic_image, R.drawable.ic_image, 1, 20));

    }
}
