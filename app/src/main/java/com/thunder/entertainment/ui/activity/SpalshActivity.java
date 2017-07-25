package com.thunder.entertainment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.thunder.entertainment.MainActivity;
import com.thunder.entertainment.R;

/**
 * Created by beibeizhu on 17/7/6.
 */

public class SpalshActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //打开主页并关闭欢迎页面
                Intent intent = new Intent(SpalshActivity.this, MainActivity.class);
                startActivity(intent);
                SpalshActivity.this.finish();
            }
        }, 1000);
    }
}
