package com.thunder.entertainment.presenter;

import com.thunder.entertainment.common.base.RxPresenter;
import com.thunder.entertainment.common.net.RetrofitHelper;
import com.thunder.entertainment.presenter.contract.VideoMainContract;

/**
 * Created by beibeizhu on 17/6/14.
 */

public class VideoMainPresenter extends RxPresenter implements VideoMainContract.Presenter {

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    private void getVideoList(String date){
        RetrofitHelper.getInstance().getKaiYanService().getVideoList(date);
    }
}
