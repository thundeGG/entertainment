package com.thunder.entertainment.presenter;

import com.thunder.entertainment.common.base.RxPresenter;
import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.common.net.RxUtils;
import com.thunder.entertainment.model.kaiyan.VideoListBean;
import com.thunder.entertainment.presenter.contract.VideoMainContract;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by beibeizhu on 17/6/14.
 */

public class VideoMainPresenter extends RxPresenter implements VideoMainContract.Presenter {

    private VideoMainContract.View view;
    private VideoListBean lastData;

    public VideoMainPresenter(VideoMainContract.View view) {
        this.view = view;
    }

    @Override
    public void onRefresh() {
        getVideoList("", true);
    }

    @Override
    public void onLoadMore() {
        int end = lastData.getNextPageUrl().lastIndexOf("&num");
        int start = lastData.getNextPageUrl().lastIndexOf("date=");
        String date = lastData.getNextPageUrl().substring(start + 5, end);
        getVideoList(date, false);
    }

    private void getVideoList(String date, final boolean isRefresh) {
        Subscription subscribe = RetrofitHelper.getInstance().getKaiYanService().getVideoList(date)
                .compose(RxUtils.<VideoListBean>threadSwitcher())
                .subscribe(new Subscriber<VideoListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isRefresh) {
                            view.refreshFaild(e.getMessage());
                        } else {
                            view.LoadMoreFaild(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(VideoListBean videoListBean) {
                        lastData = videoListBean;
                        if (isRefresh) {
                            view.refreshSuccess(videoListBean);
                        } else {
                            view.LoadMoreSuccess(videoListBean);
                        }
                    }
                });
        addSubscrebe(subscribe);
    }
}
