package com.thunder.entertainment.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by beibeizhu on 17/6/14.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    protected P mPresenter;
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    protected Unbinder mUnbinder;
    protected boolean isInit = false;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mUnbinder = ButterKnife.bind(view);
        if (savedInstanceState != null) {
            if (!isHidden()) {
                isInit = true;
                initView();
                initEvent();
                initData();
            }
        } else {
            if (!isHidden()) {
                isInit = true;
                initView();
                initEvent();
                initData();
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isInit&& !hidden){
            isInit = true;
            initView();
            initEvent();
            initData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void initData();
}
