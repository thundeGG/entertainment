package com.thunder.entertainment.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.imageutil.GlideOptions;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.model.CommentModel;
import com.thunder.entertainment.model.CommentReplyModel;

import java.util.List;

/**
 * Created by beibeizhu on 17/7/4.
 */

public class VideoCommentAdapter extends BaseQuickAdapter<CommentModel, BaseViewHolder> {
    public VideoCommentAdapter() {
        super(R.layout.item_video_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentModel item) {

        LinearLayout ll_reply = helper.getView(R.id.ll_reply);
        LinearLayout ll_reply_1 = helper.getView(R.id.ll_reply_1);
        LinearLayout ll_reply_2 = helper.getView(R.id.ll_reply_2);
        TextView tv_recly_more = helper.getView(R.id.tv_recly_more);

        helper.setText(R.id.tv_comment_name, item.getName())
                .setText(R.id.tv_comment_zan_num, item.getNum())
                .setText(R.id.tv_comment_content, item.getContent())
                .setText(R.id.tv_comment_date, item.getDate())
                .setText(R.id.tv_comment_reply_size, item.getCommentReplyList().size() + "回复")
                .setText(R.id.tv_recly_more, "查看全部" + item.getCommentReplyList().size() + "条回复");

        ImageLoader.getInstance().loadNet((ImageView) helper.getView(R.id.img_comment_url), item.getUrl(),
                new GlideOptions(R.drawable.ic_image, R.drawable.ic_image, 1, 20));

        List<CommentReplyModel> commentReplyList = item.getCommentReplyList();
        if (commentReplyList != null && commentReplyList.size() > 0) {
            ll_reply.setVisibility(View.VISIBLE);
            switch (commentReplyList.size()) {
                case 1:
                    ll_reply_1.setVisibility(View.VISIBLE);
                    ll_reply_2.setVisibility(View.GONE);
                    tv_recly_more.setVisibility(View.GONE);
                    CommentReplyModel commentReplyModel = commentReplyList.get(0);
                    helper.setText(R.id.tv_recly_name_1, commentReplyModel.getName() + ":")
                            .setText(R.id.tv_recly_content_1, commentReplyModel.getContent());
                    break;
                case 2:
                    ll_reply_1.setVisibility(View.VISIBLE);
                    ll_reply_2.setVisibility(View.VISIBLE);
                    tv_recly_more.setVisibility(View.GONE);
                    CommentReplyModel crm1 = commentReplyList.get(0);
                    CommentReplyModel crm2 = commentReplyList.get(1);
                    helper.setText(R.id.tv_recly_name_1, crm1.getName() + ":")
                            .setText(R.id.tv_recly_content_1, crm1.getContent())
                            .setText(R.id.tv_recly_name_2, crm2.getName() + ":")
                            .setText(R.id.tv_recly_content_2, crm2.getContent());
                    break;

                default:
                    ll_reply_1.setVisibility(View.VISIBLE);
                    ll_reply_2.setVisibility(View.VISIBLE);
                    tv_recly_more.setVisibility(View.VISIBLE);
                    CommentReplyModel crml1 = commentReplyList.get(0);
                    CommentReplyModel crml2 = commentReplyList.get(1);
                    helper.setText(R.id.tv_recly_name_1, crml1.getName() + ":")
                            .setText(R.id.tv_recly_content_1, crml1.getContent())
                            .setText(R.id.tv_recly_name_2, crml2.getName() + ":")
                            .setText(R.id.tv_recly_content_2, crml2.getContent());
                    break;
            }
        } else {
            ll_reply.setVisibility(View.GONE);
        }

        helper.addOnClickListener(R.id.tv_recly_more);
    }
}
