package com.thunder.entertainment.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.thunder.entertainment.R;
import com.thunder.entertainment.common.utils.imageutil.ImageLoader;
import com.thunder.entertainment.model.NewsModel;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/16.
 */

public class NewsAdapter extends BaseMultiItemQuickAdapter<NewsModel.ResultBean.DataBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public NewsAdapter(List data) {
        super(data);
        addItemType(NewsModel.ResultBean.DataBean.IMG_ONE, R.layout.item_news_one);
        addItemType(NewsModel.ResultBean.DataBean.IMG_TWO, R.layout.item_news_two);
        addItemType(NewsModel.ResultBean.DataBean.IMG_THREE, R.layout.item_news_three);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsModel.ResultBean.DataBean item) {
        helper.setText(R.id.tv_news_title, item.getTitle())
                .setText(R.id.tv_news_author_name, item.getAuthor_name())
                .setText(R.id.tv_news_date, item.getDate());

        switch (helper.getItemViewType()) {
            case NewsModel.ResultBean.DataBean.IMG_ONE:
                ImageLoader.getInstance().displayImage(mContext,item.getThumbnail_pic_s(), (ImageView) helper.getView(R.id.img_news_iamge));
                break;
            case NewsModel.ResultBean.DataBean.IMG_TWO:
                ImageLoader.getInstance().displayImage(mContext,item.getThumbnail_pic_s(), (ImageView) helper.getView(R.id.img_news_iamge));
                break;
            case NewsModel.ResultBean.DataBean.IMG_THREE:
                ImageLoader.getInstance().displayImage(mContext,item.getThumbnail_pic_s(), (ImageView) helper.getView(R.id.img_news_iamge1));
                ImageLoader.getInstance().displayImage(mContext,item.getThumbnail_pic_s02(), (ImageView) helper.getView(R.id.img_news_iamge2));
                ImageLoader.getInstance().displayImage(mContext,item.getThumbnail_pic_s03(), (ImageView) helper.getView(R.id.img_news_iamge3));
                break;
        }
    }
}
