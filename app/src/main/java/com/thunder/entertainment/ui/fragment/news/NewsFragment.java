package com.thunder.entertainment.ui.fragment.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tencent.sonic.sdk.SonicConfig;
import com.tencent.sonic.sdk.SonicEngine;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.common.web.BrowserActivity;
import com.thunder.entertainment.common.web.SonicJavaScriptInterface;
import com.thunder.entertainment.common.web.SonicRuntimeImpl;
import com.thunder.entertainment.model.NewsModel;
import com.thunder.entertainment.presenter.NewsMainPresenter;
import com.thunder.entertainment.presenter.contract.NewsMainContract;
import com.thunder.entertainment.ui.activity.news.NewsWebViewActivity;
import com.thunder.entertainment.ui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by beibeizhu on 17/6/15.
 */

public class NewsFragment extends BaseFragment<NewsMainContract.Presenter> implements NewsMainContract.View {

    public static NewsFragment newInstance(String type) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.ll_parent)
    LinearLayout mLinearLayout;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private String type;
    private NewsAdapter mAdapter;
    private List<NewsModel.ResultBean.DataBean> newsList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }


    @Override
    protected void initView() {
        type = getArguments().getString("type");
        mPresenter = new NewsMainPresenter(this);

        newsList = new ArrayList<>();
        mAdapter = new NewsAdapter(newsList);
        mSwipeRefreshLayout.setProgressViewOffset(false,100,200);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(mAdapter);

        // init sonic engine
        if (!SonicEngine.isGetInstanceAllowed()) {
            SonicEngine.createInstance(new SonicRuntimeImpl(getContext()), new SonicConfig.Builder().build());
        }
    }

    @Override
    protected void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefresh(type);
            }
        });

        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.onLoadMore();
            }
        });

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsModel.ResultBean.DataBean item = mAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), NewsWebViewActivity.class);
                intent.putExtra("url", item.getUrl());
                startActivity(intent);
//                startBrowserActivity(Config.MODE_SONIC,item.getUrl());
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.onRefresh(type);
    }

    @Override
    public void refreshFaild(String msg) {
        mAdapter.loadMoreFail();
    }

    @Override
    public void refreshSuccess(List<NewsModel.ResultBean.DataBean> dataList) {
        mSwipeRefreshLayout.setRefreshing(false);
        mAdapter.setNewData(dataList);
    }

    @Override
    public void LoadMoreSuccess(List<NewsModel.ResultBean.DataBean> dataList) {
        mAdapter.addData(dataList);
        mAdapter.loadMoreComplete();
    }


    @Override
    public void LoadMoreFaild(String msg) {
        mAdapter.loadMoreFail();
    }

    @Override
    public void notMore() {
        mAdapter.loadMoreEnd();
    }

    @Override
    public void setPresenter(NewsMainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private void startBrowserActivity(int mode,String url) {
        Intent intent = new Intent(getActivity(), BrowserActivity.class);
        intent.putExtra(BrowserActivity.PARAM_URL, url);
        intent.putExtra(BrowserActivity.PARAM_MODE, mode);
        intent.putExtra(SonicJavaScriptInterface.PARAM_CLICK_TIME, System.currentTimeMillis());
        startActivityForResult(intent, -1);
    }

}
