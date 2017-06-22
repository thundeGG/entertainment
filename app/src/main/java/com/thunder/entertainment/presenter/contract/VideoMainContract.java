package com.thunder.entertainment.presenter.contract;

import com.thunder.entertainment.common.base.BasePresenter;
import com.thunder.entertainment.common.base.BaseView;
import com.thunder.entertainment.model.NewsModel;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface VideoMainContract {

    interface View extends BaseView<VideoMainContract.Presenter> {
        void refreshFaild(String msg);

        void refreshSuccess(List<NewsModel.ResultBean> dataList);

        void LoadMoreSuccess(List<NewsModel.ResultBean> dataList);

        void LoadMoreFaild(String msg);

        void notMore();
    }

    interface Presenter extends BasePresenter {
        void onRefresh();
        void onLoadMore();
    }
}
