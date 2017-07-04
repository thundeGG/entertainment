package com.thunder.entertainment.ui.pop;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.thunder.entertainment.R;
import com.thunder.entertainment.model.CommentReplyModel;
import com.thunder.entertainment.ui.adapter.VideoCommentReplyAdapter;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/20.
 */

public class CommentReplyPopupWindow extends PopupWindow implements View.OnClickListener {

    private Context mContext;
    private View contentView;
    private ImageView img_channel_close;
    private RecyclerView rv_comment_reply;
    private VideoCommentReplyAdapter videoCommentReplyAdapter;

    public CommentReplyPopupWindow(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //获取到布局
        contentView = inflater.inflate(R.layout.pop_video_comment_reply, null);
        // 设置布局
        this.setContentView(contentView);
        //设置宽高
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置可点击
        this.setFocusable(true);
        //设置动画
        this.setAnimationStyle(R.style.channel_manager_anim);
        initView();
        initEvent();
    }

    public void setCommentReplyList(List<CommentReplyModel> commentReplyList) {
        videoCommentReplyAdapter.setNewData(commentReplyList);
    }

    private void initEvent() {
        img_channel_close.setOnClickListener(this);
    }

    private void initView() {
        img_channel_close = (ImageView) contentView.findViewById(R.id.img_channel_close);
        rv_comment_reply = (RecyclerView) contentView.findViewById(R.id.rv_comment_reply);

        videoCommentReplyAdapter = new VideoCommentReplyAdapter();
        rv_comment_reply.setLayoutManager(new LinearLayoutManager(mContext));
        rv_comment_reply.setAdapter(videoCommentReplyAdapter);

    }

    public void showContent(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent,0,0);
        }
    }

    public void close() {
        if (this.isShowing()) {
            this.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_channel_close:
                close();
                break;
        }
    }
}
