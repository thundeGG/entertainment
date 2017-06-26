package com.thunder.entertainment.ui.fragment.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.model.kaiyan.ItemListBean;
import com.thunder.entertainment.model.kaiyan.VideoListBean;
import com.thunder.entertainment.presenter.VideoMainPresenter;
import com.thunder.entertainment.presenter.contract.VideoMainContract;
import com.thunder.entertainment.ui.adapter.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by beibeizhu on 17/6/15.
 */

public class VideoFragment extends BaseFragment<VideoMainContract.Presenter> implements VideoMainContract.View {

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private LinearLayoutManager linearLayoutManager;
    private VideoAdapter mVideoAdapter;
    private List<ItemListBean> dataList;
    //是否全屏
    private boolean mFull = false;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        dataList = new ArrayList<>();

        mPresenter = new VideoMainPresenter(this);
        mVideoAdapter = new VideoAdapter(dataList);


        mSwipeRefreshLayout.setProgressViewOffset(false, 100, 200);
        mRecyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mVideoAdapter);


    }

    @Override
    protected void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefresh();
            }
        });

        mVideoAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.onLoadMore();
            }
        });

        mVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

//        mVideoAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                switch (view.getId()) {
//                    case R.id.list_item_btn:
//                        mVideoAdapter.notifyDataSetChanged();
//                        listVideoUtil.setPlayPositionAndTag(position, mVideoAdapter.TAG);
//                        final String url = mVideoAdapter.getItem(position).getData().getPlayUrl();
//                        //listVideoUtil.setCachePath(new File(FileUtils.getPath()));
//                        listVideoUtil.startPlay(url);
//                        break;
//                }
//            }
//        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int firstVisibleItem, lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(mVideoAdapter.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        if (!mFull) {
                            GSYVideoPlayer.releaseAllVideos();
                            mVideoAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });

    }

    @Override
    protected void initData() {
        mPresenter.onRefresh();
    }

    @Override
    public void refreshFaild(String msg) {

    }

    @Override
    public void refreshSuccess(VideoListBean dataList) {
        mVideoAdapter.setNewData(dataList.getItemList());
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void LoadMoreSuccess(VideoListBean dataList) {
        mVideoAdapter.addData(dataList.getItemList());
        mVideoAdapter.loadMoreComplete();
    }

    @Override
    public void LoadMoreFaild(String msg) {
        mVideoAdapter.loadMoreFail();
    }

    @Override
    public void notMore() {

    }

    @Override
    public void setPresenter(VideoMainContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            mFull = false;
        } else {
            mFull = true;
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("VideoFragment", "onPause: ");
        GSYVideoManager.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("VideoFragment", "onResume: ");
        GSYVideoManager.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("VideoFragment", "onStop: ");
        GSYVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("VideoFragment", "onDestroy: ");
        GSYVideoPlayer.releaseAllVideos();
    }


    public boolean onBackPressed() {
        if (StandardGSYVideoPlayer.backFromWindowFull(getActivity())) {
            return true;
        }
        return false;
    }
}
