package com.thunder.entertainment.ui.fragment.news;

import android.widget.TextView;

import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.model.NewsModel;
import com.thunder.entertainment.presenter.NewsMainPresenter;
import com.thunder.entertainment.presenter.contract.NewsMainContract;

import java.util.List;

import butterknife.BindView;


/**
 * Created by beibeizhu on 17/6/15.
 */

public class NewsFragment extends BaseFragment<NewsMainContract.Presenter> implements NewsMainContract.View {

    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }


    @Override
    protected void initView() {
        mPresenter = new NewsMainPresenter(this);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        mPresenter.onRefresh();
    }

    @Override
    public void refreshFaild(String msg) {
        tvResult.setText(msg);
    }

    @Override
    public void refreshSuccess(List<NewsModel.ResultBean.DataBean> dataList) {
        tvResult.setText(dataList.toString());
    }

    @Override
    public void LoadMoreSuccess(List<NewsModel.ResultBean.DataBean> dataList) {

    }


    @Override
    public void LoadMoreFaild(String msg) {

    }

    @Override
    public void notMore() {

    }

    @Override
    public void setPresenter(NewsMainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
