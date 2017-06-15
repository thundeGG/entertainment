package com.thunder.entertainment.presenter;

import com.thunder.entertainment.common.base.RxPresenter;
import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.common.net.RxUtils;
import com.thunder.entertainment.model.NewsModel;
import com.thunder.entertainment.presenter.contract.NewsMainContract;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by beibeizhu on 17/6/14.
 */

public class NewsMainPresenter extends RxPresenter implements NewsMainContract.Presenter {

    private NewsMainContract.View view;
    private int start =1;

    public NewsMainPresenter(NewsMainContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void onRefresh() {
        start =1;
        Observable<NewsModel> top = RetrofitHelper.getInstance().getJuheSercice().getNews("top", "6f99720638aa78d76e5a79fed4b0cfda", start);
        top.compose(RxUtils.<NewsModel>threadSwitcher())
                .subscribe(new Subscriber<NewsModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.refreshFaild(e.getMessage());
                    }

                    @Override
                    public void onNext(NewsModel newsModel) {
                        view.refreshSuccess(newsModel.getResult().getData());
                    }
                });
    }

    @Override
    public void onLoadMore() {
        start++;
    }
}
