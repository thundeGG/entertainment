package com.thunder.entertainment.ui.adapter;

import android.content.Context;

import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridViewAdapter;

import java.util.List;

/**
 * Created by beibeizhu on 17/7/20.
 */

public class NineAdapter extends NineGridViewAdapter {
    public NineAdapter(Context context, List<ImageInfo> imageInfo) {
        super(context, imageInfo);
    }
}
