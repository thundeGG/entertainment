package com.thunder.entertainment.ui.adapter;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.BitmapUtils;
import com.thunder.entertainment.common.utils.imageutil.GlideOptions;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.constant.ShapeConstant;
import com.thunder.entertainment.dao.table.WeiTopModel;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by beibeizhu on 17/7/20.
 */

public class WeiTopAdapter extends BaseMultiItemQuickAdapter<WeiTopModel, BaseViewHolder> {

    public WeiTopAdapter(@Nullable List<WeiTopModel> data) {
        super(data);
        addItemType(ShapeConstant.TYPE_TEXT, R.layout.item_wei_top_text);
        addItemType(ShapeConstant.TYPE_PIC, R.layout.item_wei_top_pic);
        addItemType(ShapeConstant.TYPE_VIDEO, R.layout.item_wei_top_video);
    }

    @Override
    protected void convert(BaseViewHolder helper, final WeiTopModel item) {
        helper.setText(R.id.tv_author_name, item.getAuthor_name())
                .setText(R.id.tv_date, item.getCreate_time())
                .setText(R.id.tv_content, item.getContent());

        switch (helper.getItemViewType()) {
            case ShapeConstant.TYPE_PIC:
                NineGridView nineGridView = helper.getView(R.id.nineGridView);
                String images = item.getImages();
                String[] split = images.split(",");
                List<ImageInfo> imageInfos = new ArrayList<>();
                for (String s : split) {
                    ImageInfo info = new ImageInfo();
                    info.setBigImageUrl(s);
                    info.setThumbnailUrl(s);
                    imageInfos.add(info);
                }
                nineGridView.setAdapter(new NineAdapter(mContext, imageInfos));
                break;
            case ShapeConstant.TYPE_VIDEO:
                final JCVideoPlayerStandard mVideoPlayer = helper.getView(R.id.videoplayer);
                mVideoPlayer.setUp(item.getVideo_url(), JCVideoPlayerStandard.CURRENT_STATE_NORMAL, "");


                Observable.create(new Observable.OnSubscribe<Bitmap>() {
                    @Override
                    public void call(Subscriber<? super Bitmap> subscriber) {
                        Bitmap bitmap = BitmapUtils.getNetVideoBitmap(item.getVideo_url());//获取第一帧图片
                        subscriber.onNext(bitmap);
                    }
                })
                        .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Bitmap>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Bitmap bitmap) {
                                mVideoPlayer.thumbImageView.setImageBitmap(bitmap);
                            }
                        });
                break;
        }

        ImageLoader.getInstance().loadResource((ImageView) helper.getView(R.id.img_author_url), R.drawable.thunder,
                new GlideOptions(R.drawable.ic_image, R.drawable.ic_image, 1, 20));
    }
}
