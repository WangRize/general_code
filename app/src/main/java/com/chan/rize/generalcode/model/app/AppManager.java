package com.chan.rize.generalcode.model.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Weconex_NJ_01 on 2018/2/8.
 */

public class AppManager extends Application {

    private static Context mContext;


    synchronized public static Context getAppContext() {
        return mContext.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    /**
     * 友盟接口初始化社交SDK
     */
    private void initShareSDK() {
//        //微信 appid appsecret
//        PlatformConfig.setWeixin("wxcf0f53bc22a71198", "3035065f034c3b837db35ab50cebda6a");
//        //新浪微博 appkey appsecret
//        PlatformConfig.setSinaWeibo("4115933550", "94e90d8c5f7b08a8ec7727a643a6be4c");
//        // QQ和Qzone appid appkey
//        PlatformConfig.setQQZone("1105348235", "tnGBAGlhIKXJjmIa");
    }
}
