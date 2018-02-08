package com.chan.rize.generalcode.model.db;

/**
 * Created by Weconex_NJ_01 on 2018/2/8.
 */

public final class DataBaseManager {

    volatile private static DataBaseManager mDBManager;

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
