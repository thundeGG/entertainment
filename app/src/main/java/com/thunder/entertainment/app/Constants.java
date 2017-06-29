package com.thunder.entertainment.app;

import com.thunder.entertainment.common.router.Router;

import java.io.File;

/**
 * Created by zzr on 16/11/15.
 * 常量类
 */

public class Constants {

    /********************
     * 路径相关常量
     ********************/

    //项目缓存路径
    public static final String PATH_CACHE_DIR = App.getInstance().getCacheDir().getAbsolutePath();
    //数据缓存路径
    public static final String PATH_DATA = PATH_CACHE_DIR + File.separator + "data";
    //网络请求缓存路径
    public static final String PATH_NET_CACHE = PATH_DATA + "NetCache";

    /********************* 分页相关常量 ********************/

    public static final int PAGE_SIZE = 20;

    /********************* 异常相关常量 ********************/

    public static final String EXCEPTION_API = "服务器请求异常";

    public static final int CHANNEL_STATE_NO = 0;
    public static final int CHANNEL_STATE_MY = 1;

    public static final String ACTION_CHANNEL_UPDATE = "action_channel_update";
    public static final String ACTION_CHANNEL_CURRENT = "action_channel_current";

    // #router
    public static final int ROUTER_ANIM_ENTER = Router.RES_NONE;
    public static final int ROUTER_ANIM_EXIT = Router.RES_NONE;

}
