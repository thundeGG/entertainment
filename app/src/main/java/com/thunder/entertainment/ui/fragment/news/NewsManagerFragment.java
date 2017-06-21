package com.thunder.entertainment.ui.fragment.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.thunder.entertainment.R;
import com.thunder.entertainment.app.Constants;
import com.thunder.entertainment.common.base.BaseFragment;
import com.thunder.entertainment.common.event.MessageEvent;
import com.thunder.entertainment.dao.ChannelManager;
import com.thunder.entertainment.dao.ChannelModel;
import com.thunder.entertainment.ui.fragment.ViewPageInfo;
import com.thunder.entertainment.ui.pop.ChannelPopupWindow;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    @BindView(R.id.img_news_search)
    ImageView img_news_search;
    @BindView(R.id.tab)
    ColorTrackTabLayout mColorTrackTabLayout;
    @BindView(R.id.img_news_channel_add)
    ImageView imgChannelAdd;
    @BindView(R.id.ll_parent)
    LinearLayout parent;

    private List<ViewPageInfo> fragList;
    protected FragmentStatePagerAdapter mAdapter;

    private ChannelPopupWindow channelPopupWindow;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_manager;
    }

    @Override
    protected void initView() {
        initViewPage();

        channelPopupWindow = new ChannelPopupWindow(getActivity());
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onViewPageUpdate(MessageEvent<List<ChannelModel>> event) {
        if (Constants.ACTION_CHANNEL_UPDATE.equals(event.getTag())) {
            fragList = new ArrayList<>();
            for (ChannelModel channelModel : event.getData()) {
                ViewPageInfo item = new ViewPageInfo(channelModel.getName(), NewsFragment.newInstance(channelModel.getValue()));
                fragList.add(item);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSetCurrent(MessageEvent<List<ChannelModel>> event) {
        if (Constants.ACTION_CHANNEL_CURRENT.equals(event.getTag())) {
            fragList = new ArrayList<>();
            for (ChannelModel channelModel : event.getData()) {
                ViewPageInfo item = new ViewPageInfo(channelModel.getName(), NewsFragment.newInstance(channelModel.getValue()));
                fragList.add(item);
            }
            mAdapter.notifyDataSetChanged();
            mViewPager.setCurrentItem(event.getPosition());
        }
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


    @OnClick({R.id.img_news_channel_add,R.id.img_news_search})
    public void addChannel(View view){
        switch (view.getId()) {
            case R.id.img_news_search:
                Toast.makeText(getContext(), "别点了，没接口", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_news_channel_add:
                channelPopupWindow.showContent(parent);
                break;
        }
    }

}
