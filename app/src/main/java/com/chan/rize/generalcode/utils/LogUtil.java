package com.chan.rize.generalcode.utils;

import android.util.Log;

/**
 * Created by Weconex_NJ_01 on 2018/2/8.
 */

public class LogUtil {

    private static final String APP_TAG = "application_name";
    private static final String DEFAULT_TAG = "default";

    public static void e(String msg) {
        e(DEFAULT_TAG, msg);
    }

    public static void e(String TAG, String msg) {
        Log.e(APP_TAG + TAG, msg);
    }

    public static void i(String msg) {
        i(DEFAULT_TAG, msg);
    }

    public static void i(String TAG, String msg) {
        Log.i(APP_TAG + TAG, msg);
    }

    public static void w(String msg) {
        w(DEFAULT_TAG, msg);
    }

    public static void w(String TAG, String msg) {
        Log.w(APP_TAG + TAG, msg);
    }

    public static void v(String msg) {
        v(DEFAULT_TAG, msg);
    }

    public static void v(String TAG, String msg) {
        Log.v(APP_TAG + TAG, msg);
    }
}
