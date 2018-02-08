package com.chan.rize.generalcode.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by Weconex_NJ_01 on 2018/2/8.
 */

public class MobileInfoUtil {
    private static final String TAG = "MobileInfoUtil";

    // 移动
    public static final int PHONE_TYPE_CMCC = 10086;
    // 电信
    public static final int PHONE_TYPE_CTCC = 10000;
    // 联通
    public static final int PHONE_TYPE_CUCC = 10010;
    // 未取到
    public static final int PHONE_TYPE_UNKNOW = -1;

    private int getNFCType(Context context) {
        int phoneType = PHONE_TYPE_UNKNOW;
        TelephonyManager telManager = (TelephonyManager) context.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);

        String operator = telManager.getSimOperator();
        LogUtil.i(TAG, "system sim info : " + operator);
        String simOperator = null;
        if(operator!= null){
            if(operator.equals("46000") || operator.equals("46002")|| operator.equals("46007")){
                // 中国移动
                simOperator = "中国移动";
                phoneType = PHONE_TYPE_CMCC;
            }else if(operator.equals("46001")){
                // 中国联通
                simOperator = "中国联通";
                phoneType = PHONE_TYPE_CUCC;
            }else if(operator.equals("46003")){
                // 中国电信
                simOperator = "中国电信";
                phoneType = PHONE_TYPE_CTCC;
            }
            LogUtil.i("sim result : " + simOperator);
        }
        return phoneType;
    }
}
