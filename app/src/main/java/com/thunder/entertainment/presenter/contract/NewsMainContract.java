package com.thunder.entertainment.presenter.contract;

import com.thunder.entertainment.common.base.BasePresenter;
import com.thunder.entertainment.common.base.BaseView;
import com.thunder.entertainment.model.NewsModel;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface NewsMainContract {

    interface Presenter extends BasePresenter{
        void onRefresh(String type);
        void onLoadMore();
    }

    interface View extends BaseView<Presenter> {
        void refreshFaild(String msg);

        void refreshSuccess(List<NewsModel.ResultBean.DataBean> dataList);

        void LoadMoreSuccess(List<NewsModel.ResultBean.DataBean> dataList);

        void LoadMoreFaild(String msg);

        void notMore();
    }


}
