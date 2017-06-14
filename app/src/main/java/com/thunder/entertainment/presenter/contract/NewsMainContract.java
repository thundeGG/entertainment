package com.thunder.entertainment.presenter.contract;

import com.thunder.entertainment.common.base.BasePresenter;
import com.thunder.entertainment.common.base.BaseView;
import com.thunder.entertainment.model.NewsModel;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface NewsMainContract {

    interface View extends BaseView {
        void showContent(List<NewsModel.ResultBean> dataList);
        void refreshFaild();
        void refreshSuccess();
        void LoadMoreSuccess();
    }

    interface Presenter extends BasePresenter<NewsMainContract.View> {
        void onRefresh();
        void onLoadMore();
    }
}
