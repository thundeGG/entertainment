package com.thunder.entertainment.ui.activity.news;

import android.content.Intent;

import com.thunder.entertainment.common.base.BaseWebActivity;

/**
 * Created by beibeizhu on 17/6/17.
 */

public class NewsWebViewActivity extends BaseWebActivity {

    private Intent intent;
    private String url;

    @Override
    protected String getUrl() {
        intent = getIntent();
        url = getIntent().getStringExtra("url");
        return url;
    }
}
