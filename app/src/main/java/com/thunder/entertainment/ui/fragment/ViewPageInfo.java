package com.thunder.entertainment.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by beibeizhu on 17/6/15.
 */

public class ViewPageInfo {

    public String tag;
    public View view;
    public Fragment fragment;


    public ViewPageInfo(String tag, Fragment fragment) {
        this.tag = tag;
        this.fragment = fragment;
    }

}
