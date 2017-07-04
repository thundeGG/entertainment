package com.thunder.entertainment.ui.fragment.video;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.model.kaiyan.ItemListBean;
import com.thunder.entertainment.model.kaiyan.VideoListBean;
import com.thunder.entertainment.presenter.VideoMainPresenter;
import com.thunder.entertainment.presenter.contract.VideoMainContract;
import com.thunder.entertainment.ui.activity.video.VideoDetailActivity;
import com.thunder.entertainment.ui.adapter.JieCaoVideoAdapter;

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
    private JieCaoVideoAdapter mJieCaoVideoAdapter;
    private List<ItemListBean> dataList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {


        dataList = new ArrayList<>();

        mPresenter = new VideoMainPresenter(this);
        mJieCaoVideoAdapter = new JieCaoVideoAdapter(dataList);


        mSwipeRefreshLayout.setProgressViewOffset(false, 100, 200);
        mRecyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mJieCaoVideoAdapter);


    }

    @Override
    protected void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefresh();
            }
        });

        mJieCaoVideoAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.onLoadMore();
            }
        });

        mJieCaoVideoAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_video_info:
                        startVideoDetailActivity(view,position);
//                        UrlRouter.getInstance().goVideoDetailActivity(getActivity(), mJieCaoVideoAdapter.getItem(position));
                        break;
                    case R.id.tv_pinglun:
                        startVideoDetailActivity(view,position);
//                        UrlRouter.getInstance().goVideoDetailActivity(getActivity(), mJieCaoVideoAdapter.getItem(position));
                        break;
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
        mJieCaoVideoAdapter.setNewData(dataList.getItemList());
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void LoadMoreSuccess(VideoListBean dataList) {
        mJieCaoVideoAdapter.addData(dataList.getItemList());
        mJieCaoVideoAdapter.loadMoreComplete();

    }

    @Override
    public void LoadMoreFaild(String msg) {
        mJieCaoVideoAdapter.loadMoreFail();
    }

    @Override
    public void notMore() {

    }

    @Override
    public void setPresenter(VideoMainContract.Presenter presenter) {
        mPresenter = presenter;
    }


    private void startVideoDetailActivity(View view,int position){
        Intent intent = new Intent(mContext, VideoDetailActivity.class);
        intent.putExtra("item", mJieCaoVideoAdapter.getItem(position));
        // 这里指定了共享的视图元素
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(getActivity(), view, getResources().getString(R.string.str_video_transition));
        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());

    }
}
