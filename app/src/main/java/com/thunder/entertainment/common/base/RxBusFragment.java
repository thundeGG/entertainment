package com.thunder.entertainment.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hwangjr.rxbus.RxBus;

/**
 * Created by beibeizhu on 17/6/20.
 */

public abstract class RxBusFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
