package com.thunder.entertainment.presenter.contract;

import com.thunder.entertainment.common.base.BasePresenter;
import com.thunder.entertainment.common.base.BaseView;
import com.thunder.entertainment.model.kaiyan.VideoListBean;

/**
 * Created by beibeizhu on 17/6/14.
 */

public interface VideoMainContract {

    interface View extends BaseView<VideoMainContract.Presenter> {
        void refreshFaild(String msg);

        void refreshSuccess(VideoListBean dataList);

        void LoadMoreSuccess(VideoListBean dataList);

        void LoadMoreFaild(String msg);

        void notMore();
    }

    interface Presenter extends BasePresenter {
        void onRefresh();
        void onLoadMore();
    }
}
