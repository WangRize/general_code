package com.chan.rize.generalcode.model.db;

import android.os.Handler;

/**
 * Created by rize on 2018/2/8.
 */

public final class DataBaseManager {

    volatile private static DataBaseManager mDBManager = null;

    Handler mHandler = null;

    private DataBaseManager() {

    }

    public static DataBaseManager getInstance() {
        if (null == mDBManager) {
            synchronized (DataBaseManager.class) {
                if (null == mDBManager) {
                    mDBManager = new DataBaseManager();
                }
            }
        }
        return mDBManager;
    }
}
