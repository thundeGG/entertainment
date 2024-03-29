package com.thunder.entertainment.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hwangjr.rxbus.RxBus;

/**
 * Created by beibeizhu on 17/6/20.
 */

public abstract class RxBusActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
