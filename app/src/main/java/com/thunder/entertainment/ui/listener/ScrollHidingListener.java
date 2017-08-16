package com.thunder.entertainment.ui.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by beibeizhu on 17/7/20.
 * <p>
 * 滑动隐藏监听
 */

public abstract class ScrollHidingListener extends RecyclerView.OnScrollListener {
    //滑动隐藏的阙值
    private static final int HIDE_HTRESHOLE = 20;
    //滑动的距离
    private int mScrolledDistance = 0;
    //控件的显示状态  默认为显示状态
    private boolean isShow = true;

    private static String TAG = "ScrollHidingListener";

    /**
     * 向下滑动隐藏控件, 向上滑动显示控件
     * dy, 向下滑动为正值, 向上滑动为负值
     */
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        ///*
        /// 获取当前显示的第一个控件的位置
        /// 注意：只在LinearLayoutManager情况下有效
        /// */
        int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();



        //滑到顶部
        if (firstVisibleItemPosition == 0) {
            if (!isShow) {
                onShow();
                isShow = true;
            }
        } else if (mScrolledDistance > HIDE_HTRESHOLE && isShow) {
            //没有滑到顶部  向下滑动
            onHide();
            isShow = false;
            mScrolledDistance = 0;
        } else if (mScrolledDistance < -HIDE_HTRESHOLE && !isShow) {
            onShow();
            isShow = true;
            mScrolledDistance = 0;
        }

        if ((isShow && dy > 0) || (!isShow && dy < 0)) {
            mScrolledDistance += dy;
            Log.i(TAG, "onScrolled: mScrolledDistance=" + mScrolledDistance);
        }

    }


    protected abstract void onHide();

    protected abstract void onShow();
}
