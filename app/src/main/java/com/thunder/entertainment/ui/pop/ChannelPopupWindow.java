package com.thunder.entertainment.ui.pop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.thunder.entertainment.R;
import com.thunder.entertainment.app.Constants;
import com.thunder.entertainment.common.event.MessageEvent;
import com.thunder.entertainment.dao.ChannelManager;
import com.thunder.entertainment.dao.ChannelModel;
import com.thunder.entertainment.ui.adapter.MyChannelAdapter;
import com.thunder.entertainment.ui.adapter.NoChannelAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/20.
 */

public class ChannelPopupWindow extends PopupWindow implements View.OnClickListener {

    private Context mContext;
    private View contentView;
    private ImageView img_channel_close;
    private TextView tv_update;
    private RecyclerView rv_my_channel;
    private MyChannelAdapter myChannelAdapter;
    private RecyclerView rv_no_channel;
    private NoChannelAdapter noChannelAdapter;

    public ChannelPopupWindow(Context context) {
        mContext = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //获取到布局
        contentView = inflater.inflate(R.layout.pop_channel_manager, null);
        // 设置布局
        this.setContentView(contentView);
        //设置宽高
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置可点击
        this.setFocusable(true);
        //设置动画
        this.setAnimationStyle(R.style.channel_manager_anim);
        initView();
        initData();
        initEvent();
    }

    private void initData() {
        List<ChannelModel> choiseChannel = ChannelManager.getInstance().getChoiseChannel();
        myChannelAdapter.setNewData(choiseChannel);

        List<ChannelModel> noneChannel = ChannelManager.getInstance().getNoneChannel();
        noChannelAdapter.setNewData(noneChannel);
    }

    private void initEvent() {
        tv_update.setOnClickListener(this);
        img_channel_close.setOnClickListener(this);

        myChannelAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.img_channel_cancel:
                        ChannelModel item = myChannelAdapter.getItem(position);
                        item.setState(Constants.CHANNEL_STATE_NO);
                        ChannelManager.getInstance().updateChannel(item);
                        myChannelAdapter.remove(position);
                        noChannelAdapter.addData(0, item);
                        break;
                }
            }
        });

        myChannelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MessageEvent<List<ChannelModel>> messageEvent =new MessageEvent<>();
                messageEvent.setTag(Constants.ACTION_CHANNEL_CURRENT);
                messageEvent.setPosition(position);
                messageEvent.setData(myChannelAdapter.getData());
                EventBus.getDefault().post(messageEvent);
                close();
            }
        });

        noChannelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ChannelModel item = noChannelAdapter.getItem(position);
                item.setState(Constants.CHANNEL_STATE_MY);
                ChannelManager.getInstance().updateChannel(item);
                noChannelAdapter.remove(position);
                myChannelAdapter.addData(item);
            }
        });

        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                if (myChannelAdapter.isUpdate()) {
                    myChannelAdapter.setUpdateState(false);
                    tv_update.setText("编辑");
                }
            }
        });
    }

    private void initView() {
        tv_update = (TextView) contentView.findViewById(R.id.tv_update);
        img_channel_close = (ImageView) contentView.findViewById(R.id.img_channel_close);
        rv_my_channel = (RecyclerView) contentView.findViewById(R.id.rv_my_channel);
        rv_no_channel = (RecyclerView) contentView.findViewById(R.id.rv_no_channel);

        myChannelAdapter = new MyChannelAdapter();
        rv_my_channel.setLayoutManager(new GridLayoutManager(mContext, 4));
        rv_my_channel.setAdapter(myChannelAdapter);

        noChannelAdapter = new NoChannelAdapter();
        rv_no_channel.setLayoutManager(new GridLayoutManager(mContext, 4));
        rv_no_channel.setAdapter(noChannelAdapter);
    }

    public void showContent(View parent) {
        if (!this.isShowing()) {
            this.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        }
    }

    public void close() {
        if (this.isShowing()) {
            this.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_update:
                if (myChannelAdapter.isUpdate()) {
                    tv_update.setText("编辑");
                    myChannelAdapter.setUpdateState(false);
                } else {
                    tv_update.setText("完成");
                    myChannelAdapter.setUpdateState(true);
                }

                break;
            case R.id.img_channel_close:
                MessageEvent<List<ChannelModel>> messageEvent =new MessageEvent<>();
                messageEvent.setTag(Constants.ACTION_CHANNEL_UPDATE);
                messageEvent.setData(myChannelAdapter.getData());
                EventBus.getDefault().post(messageEvent);
//                RxBus.get().post(Constants.ACTION_CHANNEL_UPDATE,myChannelAdapter.getData());
                close();
                break;
        }
    }
}
