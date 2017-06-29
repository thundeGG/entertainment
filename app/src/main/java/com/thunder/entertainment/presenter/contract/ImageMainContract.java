package com.thunder.entertainment.presenter.contract;

import com.thunder.entertainment.common.base.BasePresenter;
import com.thunder.entertainment.common.base.BaseView;
import com.thunder.entertainment.model.GankModel;
import com.thunder.entertainment.model.NewsModel;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface ImageMainContract {

    interface Presenter extends BasePresenter {
        void onRefresh();

        void onLoadMore();
    }

    interface View extends BaseView<ImageMainContract.Presenter> {
        void refreshFaild(String msg);

        void refreshSuccess(List<GankModel> dataList);

        void LoadMoreSuccess(List<GankModel> dataList);

        void LoadMoreFaild(String msg);

        void notMore();
    }


}
