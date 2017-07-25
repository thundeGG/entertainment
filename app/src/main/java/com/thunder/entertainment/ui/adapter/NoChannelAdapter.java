package com.thunder.entertainment.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.dao.table.ChannelModel;

/**
 * Created by beibeizhu on 17/6/20.
 */

public class NoChannelAdapter extends BaseQuickAdapter<ChannelModel, BaseViewHolder> {

    private boolean isUpdate = false;

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdateState(boolean isUpdate) {
        this.isUpdate = isUpdate;
        notifyDataSetChanged();
    }

    public NoChannelAdapter() {
        super(R.layout.item_no_channel);
    }


    @Override
    protected void convert(BaseViewHolder helper, ChannelModel item) {

        helper.setText(R.id.tv_channel_name, "＋ " + item.getName());

        helper.addOnClickListener(R.id.img_channel_cancel);
    }
}
