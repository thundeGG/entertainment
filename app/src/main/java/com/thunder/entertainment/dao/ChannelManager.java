package com.thunder.entertainment.dao;

import com.thunder.entertainment.app.Constants;
import com.thunder.entertainment.dao.table.ChannelModel;

import java.util.List;

import entertainment.dao.ChannelModelDao;
import entertainment.dao.GreenDaoHelper;

/**
 * Created by beibeizhu on 17/6/16.
 */

public class ChannelManager {

    private ChannelManager() {

    }

    private static ChannelManager instance = null;


    private static ChannelModelDao channelModelDao;


    public static ChannelManager getInstance() {
        if (instance == null) {//懒汉式
            synchronized (ChannelManager.class) {
                if (instance == null) {//二次检查
                    instance = new ChannelManager();
                }
            }
        }
        return instance;
    }

    public void initData() {
        channelModelDao = GreenDaoHelper.getDaoSession().getChannelModelDao();

        List<ChannelModel> channelModels = channelModelDao.loadAll();
        if (channelModels == null || channelModels.size() == 0) {
            ChannelModel topChannel = new ChannelModel();
            topChannel.setId(null);
            topChannel.setName("头条");
            topChannel.setValue("top");
            topChannel.setState(Constants.CHANNEL_STATE_MY);


            ChannelModel shehuiChannel = new ChannelModel();
            shehuiChannel.setId(null);
            shehuiChannel.setName("社会");
            shehuiChannel.setValue("shehui");
            shehuiChannel.setState(Constants.CHANNEL_STATE_MY);

            ChannelModel guoneiChannel = new ChannelModel();
            guoneiChannel.setId(null);
            guoneiChannel.setName("国内");
            guoneiChannel.setValue("guonei");
            guoneiChannel.setState(Constants.CHANNEL_STATE_MY);


            ChannelModel guojiChannel = new ChannelModel();
            guojiChannel.setId(null);
            guojiChannel.setName("国际");
            guojiChannel.setValue("guoji");
            guojiChannel.setState(Constants.CHANNEL_STATE_MY);


            ChannelModel yuleChannel = new ChannelModel();
            yuleChannel.setId(null);
            yuleChannel.setName("娱乐");
            yuleChannel.setValue("yule");
            yuleChannel.setState(Constants.CHANNEL_STATE_NO);


            ChannelModel tiyuChannel = new ChannelModel();
            tiyuChannel.setId(null);
            tiyuChannel.setName("体育");
            tiyuChannel.setValue("tiyu");
            tiyuChannel.setState(Constants.CHANNEL_STATE_NO);


            ChannelModel junshiChannel = new ChannelModel();
            junshiChannel.setId(null);
            junshiChannel.setName("军事");
            junshiChannel.setValue("junshi");
            junshiChannel.setState(Constants.CHANNEL_STATE_NO);


            ChannelModel kejiChannel = new ChannelModel();
            kejiChannel.setId(null);
            kejiChannel.setName("科技");
            kejiChannel.setValue("keji");
            kejiChannel.setState(Constants.CHANNEL_STATE_NO);


            ChannelModel caijingChannel = new ChannelModel();
            caijingChannel.setId(null);
            caijingChannel.setName("财经");
            caijingChannel.setValue("caijing");
            caijingChannel.setState(Constants.CHANNEL_STATE_NO);


            ChannelModel shishangChannel = new ChannelModel();
            shishangChannel.setId(null);
            shishangChannel.setName("时尚");
            shishangChannel.setValue("shishang");
            shishangChannel.setState(Constants.CHANNEL_STATE_NO);

            channelModelDao.insert(topChannel);
            channelModelDao.insert(shehuiChannel);
            channelModelDao.insert(guoneiChannel);
            channelModelDao.insert(guojiChannel);
            channelModelDao.insert(yuleChannel);
            channelModelDao.insert(tiyuChannel);
            channelModelDao.insert(junshiChannel);
            channelModelDao.insert(kejiChannel);
            channelModelDao.insert(caijingChannel);
            channelModelDao.insert(shishangChannel);
        }
    }

    public List<ChannelModel> getChoiseChannel() {
        return channelModelDao.queryBuilder().where(ChannelModelDao.Properties.State.eq(1)).list();
    }

    public List<ChannelModel> getNoneChannel() {
        return channelModelDao.queryBuilder().where(ChannelModelDao.Properties.State.eq(0)).list();
    }

    public void updateChannel(ChannelModel channelModel) {
        channelModelDao.update(channelModel);
    }
}
