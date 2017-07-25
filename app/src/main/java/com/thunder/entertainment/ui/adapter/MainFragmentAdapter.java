package com.thunder.entertainment.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.thunder.entertainment.ui.fragment.ViewPageInfo;

import java.util.List;

/**
 * Created by beibeizhu on 17/7/11.
 */

public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private List<ViewPageInfo> fragList;

    public MainFragmentAdapter(FragmentManager fm, List<ViewPageInfo> fragList) {
        super(fm);
        this.fragList = fragList;
    }

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position).fragment;
    }

    @Override
    public int getCount() {
        return fragList == null ? 0 : fragList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragList.get(position).tag;
    }

    public void setUpdate(List<ViewPageInfo> viewPageInfoList){
        this.fragList = viewPageInfoList;
        notifyDataSetChanged();
    }

}
