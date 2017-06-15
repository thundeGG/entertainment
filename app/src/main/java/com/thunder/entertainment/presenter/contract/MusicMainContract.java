package com.thunder.entertainment.presenter.contract;

import com.thunder.entertainment.common.base.BasePresenter;
import com.thunder.entertainment.common.base.BaseView;
import com.thunder.entertainment.model.NewsModel;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface MusicMainContract {

    interface View extends BaseView<MusicMainContract.Presenter> {
        void refreshFaild(String msg);

        void refreshSuccess(List<NewsModel.ResultBean> dataList);

        void LoadMoreSuccess(List<NewsModel.ResultBean> dataList);

        void LoadMoreFaild(String msg);

        void notMore();
    }

    interface Presenter extends BasePresenter{
        void onRefresh();
        void onLoadMore();
    }
}
