package com.thunder.entertainment.ui.fragment.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.thunder.entertainment.R;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.dao.ChannelManager;
import com.thunder.entertainment.dao.ChannelModel;
import com.thunder.entertainment.ui.fragment.ViewPageInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.weyye.library.colortrackview.ColorTrackTabLayout;

/**
 * Created by beibeizhu on 17/6/16.
 */

public class NewsManagerFragment extends BaseFragment {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.tab)
    ColorTrackTabLayout mColorTrackTabLayout;
    @BindView(R.id.img_news_channel_add)
    ImageView imgChannelAdd;

    private List<ViewPageInfo> fragList;
    protected FragmentStatePagerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_manager;
    }

    @Override
    protected void initView() {
        initViewPage();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    private void initViewPage() {
        if (mAdapter == null) {
            fragList = new ArrayList<>();
            List<ChannelModel> channelModelList = ChannelManager.getInstance().getChoiseChannel();

            for (ChannelModel channelModel : channelModelList) {
                ViewPageInfo item = new ViewPageInfo(channelModel.getName(), NewsFragment.newInstance(channelModel.getValue()));
                fragList.add(item);
            }


            mAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
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
            if (mViewPager != null) {
                mViewPager.setAdapter(mAdapter);
            }

        } else {
            if (mViewPager != null) {
                mViewPager.setAdapter(mAdapter);
            }
        }

        mColorTrackTabLayout.setupWithViewPager(mViewPager);
    }


    @OnClick(R.id.img_news_channel_add)
    public void addChannel(View view){
        Toast.makeText(getActivity(),"点击了",Toast.LENGTH_SHORT).show();
    }

}
