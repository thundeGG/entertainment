package com.thunder.entertainment;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.thunder.entertainment.common.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
     AHBottomNavigation ahBottomNavigation;
    @BindView(R.id.view_pager)
    AHBottomNavigationViewPager aHBottomNavigationViewPager;

    private FragmentManager mPopToTempFragmentManager;

    @Override
    protected void initView() {
        // 创建底部导航的每一项
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_import_contacts, R.color.color_tab_normal);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_image, R.color.color_tab_normal);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_audiotrack, R.color.color_tab_normal);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.ic_live_tv, R.color.color_tab_normal);

        // 添加到导航中
        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);

        // 设置背景颜色
        ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        // Change colors
        ahBottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        ahBottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        // Force to tint the drawable (useful for font with icon for example)
        ahBottomNavigation.setForceTint(false);

        //设置导航文字显示方式
        // TitleState.SHOW_WHEN_ACTIVE  选中才显示
        // TitleState.ALWAYS_SHOW       总是显示
        // TitleState.ALWAYS_HIDE       总是隐藏
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        // Set current item programmatically
        ahBottomNavigation.setCurrentItem(1);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
