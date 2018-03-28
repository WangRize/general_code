package com.chan.rize.generalcode.utils;

import android.util.Log;

import com.chan.rize.generalcode.BuildConfig;

/**
 * Created by rize on 2018/2/8.
 */
public class LogUtil {

    private static final String APP_TAG = "application_name";
    private static final String DEFAULT_TAG = "default";

    private static final boolean LOG_SWITCH = BuildConfig.enableLog;

    public static void e(String msg) {
        e(DEFAULT_TAG, msg);
    }

    public static void e(String TAG, String msg) {
        Log.e(APP_TAG + TAG, msg);
    }

    public static void d(String msg) {
        d(DEFAULT_TAG, msg);
    }

    public static void d(String TAG, String msg) {
        if (LOG_SWITCH) {
            Log.d(APP_TAG + TAG, msg);
        }
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
