package com.thunder.entertainment.dao;

import com.thunder.entertainment.dao.table.WeiTopModel;

import java.util.List;

import entertainment.dao.GreenDaoHelper;
import entertainment.dao.WeiTopModelDao;

/**
 * Created by beibeizhu on 17/6/16.
 */

public class ShapeManager {

    private ShapeManager() {

    }

    private static ShapeManager instance = null;


    private WeiTopModelDao weiTopModelDao;


    public static ShapeManager getInstance() {
        if (instance == null) {//懒汉式
            synchronized (ShapeManager.class) {
                if (instance == null) {//二次检查
                    instance = new ShapeManager();
                }
            }
        }
        return instance;
    }

    public void initData() {
        weiTopModelDao = GreenDaoHelper.getDaoSession().getWeiTopModelDao();
    }

    public List<WeiTopModel> getList() {
        return weiTopModelDao.queryBuilder().orderDesc(WeiTopModelDao.Properties.Create_time).list();
    }

    public void  addWeiTop(WeiTopModel weiTopModel){
        weiTopModelDao.insert(weiTopModel);
    }
}
