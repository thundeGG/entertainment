package com.thunder.entertainment.ui.fragment.image;

import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.model.NewsModel;
import com.thunder.entertainment.presenter.contract.ImageMainContract;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/15.
 */

public class ImageFragment extends  BaseFragment<ImageMainContract.Presenter> implements ImageMainContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void refreshFaild(String msg) {

    }

    @Override
    public void refreshSuccess(List<NewsModel.ResultBean> dataList) {

    }

    @Override
    public void LoadMoreSuccess(List<NewsModel.ResultBean> dataList) {

    }

    @Override
    public void LoadMoreFaild(String msg) {

    }

    @Override
    public void notMore() {

    }

    @Override
    public void setPresenter(ImageMainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
