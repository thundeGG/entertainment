package com.thunder.entertainment.ui.activity.video;

import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseActivity;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.model.CommentModel;
import com.thunder.entertainment.model.CommentReplyModel;
import com.thunder.entertainment.model.kaiyan.ItemListBean;
import com.thunder.entertainment.model.kaiyan.VideoListBean;
import com.thunder.entertainment.presenter.VideoDetailPresenter;
import com.thunder.entertainment.presenter.contract.VideoDetailContract;
import com.thunder.entertainment.ui.adapter.VideoCommentAdapter;
import com.thunder.entertainment.ui.pop.CommentReplyPopupWindow;

import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by beibeizhu on 17/7/4.
 */

public class VideoDetailActivity extends BaseActivity<VideoDetailContract.Presenter> implements VideoDetailContract.View {

    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoPlayer;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll_parent)
    LinearLayout parent;

    private CommentReplyPopupWindow commentReplyPopupWindow;

    private VideoCommentAdapter videoCommentAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ItemListBean itemListBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    @Override
    protected void initView() {

        mPresenter = new VideoDetailPresenter(this);
        itemListBean = getIntent().getParcelableExtra("item");
        String url = itemListBean.getData().getPlayUrl();
        String title = itemListBean.getData().getTitle();
        videoPlayer.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
        videoPlayer.ACTION_BAR_EXIST = false;
        videoPlayer.TOOL_BAR_EXIST = false;
        videoPlayer.backButton.setVisibility(View.VISIBLE);
        ImageView imageView = videoPlayer.thumbImageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(mContext, itemListBean.getData().getCover().getDetail(), imageView);

        linearLayoutManager = new LinearLayoutManager(this);
        videoCommentAdapter = new VideoCommentAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(videoCommentAdapter);

        videoPlayer.startButton.performClick();

        commentReplyPopupWindow = new CommentReplyPopupWindow(this);
    }

    @Override
    protected void initEvent() {
        videoCommentAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_recly_more:
                        commentReplyPopupWindow.setCommentReplyList(videoCommentAdapter.getData().get(position).getCommentReplyList());

                        commentReplyPopupWindow.showContent(videoPlayer);
                        break;
                }
            }
        });

        videoPlayer.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }else{
                    finish();
                }
            }
        });
    }

    @Override
    protected void initData() {

        mPresenter.getCommentList();
        mPresenter.getRecommendList();
    }

    @Override
    public void setPresenter(VideoDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void showComment(List<CommentModel> commentModelList) {
        videoCommentAdapter.setNewData(commentModelList);
    }


    @Override
    public void showReply(List<CommentReplyModel> commentReplyModels) {

    }

    @Override
    public void showRecommend(VideoListBean videoListBeanList) {

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
