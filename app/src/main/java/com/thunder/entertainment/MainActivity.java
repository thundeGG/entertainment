package com.thunder.entertainment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.thunder.entertainment.common.base.BaseActivity;
import com.thunder.entertainment.ui.fragment.ViewPageInfo;
import com.thunder.entertainment.ui.fragment.image.ImageFragment;
import com.thunder.entertainment.ui.fragment.movie.MovieFragment;
import com.thunder.entertainment.ui.fragment.music.MusicFragment;
import com.thunder.entertainment.ui.fragment.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
     AHBottomNavigation ahBottomNavigation;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<ViewPageInfo> fragList;
    protected FragmentStatePagerAdapter mAdapter;

    @Override
    protected void initView() {
        initBottomNavigation();
        initViewPage();
    }

    private void initViewPage() {
        if (mAdapter == null){
            fragList = new ArrayList<>();
            ViewPageInfo newsItem = new ViewPageInfo("news", new NewsFragment());
            ViewPageInfo imageItem = new ViewPageInfo("image", new ImageFragment());
            ViewPageInfo musicItem = new ViewPageInfo("music", new MusicFragment());
            ViewPageInfo movieItem = new ViewPageInfo("movie", new MovieFragment());
            fragList.add(newsItem);
            fragList.add(imageItem);
            fragList.add(musicItem);
            fragList.add(movieItem);

            mAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragList.get(position).fragment;
                }

                @Override
                public int getCount() {
                    return fragList.size();
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return fragList.get(position).tag;
                }


            };
            if (mViewPager !=null) {
                mViewPager.setAdapter(mAdapter);
            }

        }else{
            if (mViewPager !=null) {
                mViewPager.setAdapter(mAdapter);
            }
        }
    }

    public void initBottomNavigation() {
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
        ahBottomNavigation.setAccentColor(Color.parseColor(getString(R.string.color_tab_accent)));
        ahBottomNavigation.setInactiveColor(Color.parseColor(getString(R.string.color_tab_inactive)));

        // Force to tint the drawable (useful for font with icon for example)
        ahBottomNavigation.setForceTint(false);

        //设置导航文字显示方式
        // TitleState.SHOW_WHEN_ACTIVE  选中才显示
        // TitleState.ALWAYS_SHOW       总是显示
        // TitleState.ALWAYS_HIDE       总是隐藏
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        // 设置当前选中　
        ahBottomNavigation.setCurrentItem(0);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {
        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                mViewPager.setCurrentItem(position);
                return true;
            }
        });
    }

    @Override
    protected void initData() {

    }

}
