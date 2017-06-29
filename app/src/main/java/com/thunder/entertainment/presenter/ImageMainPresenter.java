package com.thunder.entertainment.presenter;

import android.database.Observable;

import com.thunder.entertainment.app.Constants;
import com.thunder.entertainment.common.base.RxPresenter;
import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.common.net.RxUtils;
import com.thunder.entertainment.model.GankBaesResponse;
import com.thunder.entertainment.model.GankModel;
import com.thunder.entertainment.presenter.contract.ImageMainContract;
import com.thunder.entertainment.presenter.contract.NewsMainContract;

import java.util.List;

import rx.Subscriber;

/**
 * Created by beibeizhu on 17/6/14.
 */

public class ImageMainPresenter extends RxPresenter implements ImageMainContract.Presenter {
    private ImageMainContract.View view;
    private String type;
    private int page = 1;
    final private String WEAL = "福利";

    public ImageMainPresenter(ImageMainContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void onRefresh() {
        rx.Observable<GankBaesResponse<List<GankModel>>> gankWeal = RetrofitHelper.getInstance().getGankSercice().getGankImage(WEAL, Constants.PAGE_SIZE, page);
        gankWeal.compose(RxUtils.<GankBaesResponse<List<GankModel>>>threadSwitcher())
                .subscribe(new Subscriber<GankBaesResponse<List<GankModel>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.refreshFaild(e.getMessage());

                    }

                    @Override
                    public void onNext(GankBaesResponse<List<GankModel>> listGankBaesResponse) {
                        view.refreshSuccess(listGankBaesResponse.getResults());
                    }
                });
    }

    @Override
    public void onLoadMore() {
        page++;
        rx.Observable<GankBaesResponse<List<GankModel>>> gankWeal = RetrofitHelper.getInstance().getGankSercice().getGankImage(WEAL, Constants.PAGE_SIZE, page);
        gankWeal.compose(RxUtils.<GankBaesResponse<List<GankModel>>>threadSwitcher())
                .subscribe(new Subscriber<GankBaesResponse<List<GankModel>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.LoadMoreFaild(e.getMessage());
                    }

                    @Override
                    public void onNext(GankBaesResponse<List<GankModel>> listGankBaesResponse) {
                        List<GankModel> listWeal = listGankBaesResponse.getResults();
                        if (listWeal != null && listWeal.size() != 0) {
                            view.LoadMoreSuccess(listGankBaesResponse.getResults());
                        } else {
                            view.notMore();
                        }
                    }
                });

    }

}
