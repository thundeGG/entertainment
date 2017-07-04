package com.thunder.entertainment.ui.fragment.image;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.model.GankModel;
import com.thunder.entertainment.presenter.ImageMainPresenter;
import com.thunder.entertainment.presenter.contract.ImageMainContract;
import com.thunder.entertainment.ui.activity.image.ImagePreviewActivity;
import com.thunder.entertainment.ui.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by beibeizhu on 17/6/15.
 */

public class ImageFragment extends BaseFragment<ImageMainContract.Presenter> implements ImageMainContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private ImageAdapter mImageAdapter;
    private List<GankModel> mGankModels;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image;
    }

    @Override
    protected void initView() {
        mGankModels = new ArrayList<>();
        mPresenter = new ImageMainPresenter(this);
        mImageAdapter = new ImageAdapter(R.layout.item_image);
        mImageAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mSwipeRefreshLayout.setProgressViewOffset(false, 100, 200);
        mRecyclerView.setPadding(8, 8, 8, 8);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setAdapter(mImageAdapter);
    }

    @Override
    protected void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefresh();
            }
        });
        mImageAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.onLoadMore();
            }
        });
        mImageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ImagePreviewActivity.class);
                intent.putExtra(ImagePreviewActivity.URL_TAG,mGankModels.get(position).getUrl());
                // 这里指定了共享的视图元素
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(getActivity(), view, getResources().getString(R.string.str_gank_transition));
                ActivityCompat.startActivity(getActivity(), intent, options.toBundle());

//                UrlRouter.getInstance().goImagePreViewActivity(getActivity(), mGankModels.get(position).getUrl());
//                Toast.makeText(mActivity, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.onRefresh();
    }

    @Override
    public void refreshFaild(String msg) {
        mImageAdapter.loadMoreFail();
    }

    @Override
    public void refreshSuccess(List<GankModel> dataList) {
        mGankModels = dataList;
        mSwipeRefreshLayout.setRefreshing(false);
        mImageAdapter.setNewData(dataList);
    }

    @Override
    public void LoadMoreSuccess(List<GankModel> dataList) {
        mImageAdapter.addData(dataList);
        mImageAdapter.loadMoreComplete();
    }

    @Override
    public void LoadMoreFaild(String msg) {
        mImageAdapter.loadMoreFail();
    }

    @Override
    public void notMore() {
        mImageAdapter.loadMoreEnd();
    }

    @Override
    public void setPresenter(ImageMainContract.Presenter presenter) {
        mPresenter = presenter;
    }

}
