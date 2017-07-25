package com.thunder.entertainment.ui.adapter;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.dao.table.ChannelModel;

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
        TextView tv_channel_name = helper.getView(R.id.tv_channel_name);

        helper.setText(R.id.tv_channel_name, item.getName());
        int adapterPosition = helper.getAdapterPosition();
        if (adapterPosition == 0) {
            tv_channel_name.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        } else {
            tv_channel_name.setTextColor(ContextCompat.getColor(mContext, R.color.black));
        }
        if (isUpdate && adapterPosition != 0) {
            img_channel_cancel.setVisibility(View.VISIBLE);
        } else {
            img_channel_cancel.setVisibility(View.GONE);
        }

        helper.addOnClickListener(R.id.img_channel_cancel);
    }
}
