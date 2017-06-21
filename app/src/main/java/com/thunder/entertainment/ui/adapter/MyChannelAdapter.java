package com.thunder.entertainment.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.dao.ChannelModel;

/**
 * Created by beibeizhu on 17/6/20.
 */

public class MyChannelAdapter extends BaseQuickAdapter<ChannelModel, BaseViewHolder> {

    private boolean isUpdate = false;

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdateState(boolean isUpdate) {
        this.isUpdate = isUpdate;
        notifyDataSetChanged();
    }

    public MyChannelAdapter() {
        super(R.layout.item_my_channel);
    }


    @Override
    protected void convert(BaseViewHolder helper, ChannelModel item) {
        ImageView img_channel_cancel = helper.getView(R.id.img_channel_cancel);

        helper.setText(R.id.tv_channel_name, item.getName());

        if (isUpdate) {
            img_channel_cancel.setVisibility(View.VISIBLE);
        } else {
            img_channel_cancel.setVisibility(View.GONE);
        }

        helper.addOnClickListener(R.id.img_channel_cancel);
    }
}
