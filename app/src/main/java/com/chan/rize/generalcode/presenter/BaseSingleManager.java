package com.chan.rize.generalcode.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用单例多线程管理基类
 */

public class BaseSingleManager {

    private Context mContext;
    private Handler mLogicHandler;
    private Handler mUIHandler;
    private Map<String, Callback2UI> mCodeCallbackMap;
    private static BaseSingleManager mManager;

    protected BaseSingleManager(Context context) {
        mContext = context;
        mCodeCallbackMap = new HashMap<>();
        HandlerThread ownThread = new HandlerThread(this.getClass().getName());
        ownThread.start();
        mLogicHandler = new Handler(ownThread.getLooper()) {
            @Override
            public void dispatchMessage(Message msg) {
                doDispatchMessage(msg);
            }
        };
        mUIHandler = new Handler(context.getMainLooper()) {
            @Override
            public void dispatchMessage(Message msg) {
                dispatchMessage2UI(msg);
            }
        };
    }

    public synchronized static BaseSingleManager getInstance(Context context) {
        if (null == mManager) {
            synchronized (BaseSingleManager.class) {
                if (null == mManager) {
                    mManager = new BaseSingleManager(context.getApplicationContext());
                }
            }
        }
        return mManager;
    }

    protected void doDispatchMessage(Message msg) {}

    protected void dispatchMessage2UI(Message msg) {}

    public void releaseResources() {
        if (null != mLogicHandler) {
            mLogicHandler.removeCallbacksAndMessages(null);
            mLogicHandler = null;
        }
        if (null != mUIHandler) {
            mUIHandler.removeCallbacksAndMessages(null);
            mUIHandler = null;
        }
    }

    interface Callback2UI {
        void callbackResult();
    }

}
