package com.chan.rize.generalcode.utils.pay.alipay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

/**
 * Created by chenweihui on 2017-9-12.
 */

public class AlipayOperator {

    private static final String TAG = AlipayOperator.class.getSimpleName();
    private static final int WHAT_ALIPAY_RESULT = 1;

    private static OnAlipayCallback callback;

    private static Handler alipayHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case WHAT_ALIPAY_RESULT:
                    if (msg.obj instanceof Map) {
                        PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                        String resultStatus = payResult.getResultStatus();
                        // 判断resultStatus 为9000则代表支付成功
                        if (TextUtils.equals(resultStatus, "9000")) {
                            // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                            if (callback != null) callback.onSuccess("支付成功");
                            break;
                        }
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        if (callback != null) callback.onFail("支付失败");
                    }

                    break;
            }
        }
    };

    public void executeAlipay(final boolean isDebug, final Activity activity, final String orderInfo, OnAlipayCallback callback) {
        this.callback = callback;
        new Thread(new Runnable() {
            @Override
            public void run() {
                PayTask payTask = new PayTask(activity);
                Map<String, String> result = payTask.payV2(orderInfo, true);

                if (isDebug) {
                    Log.i(TAG, "---------------------------------------------------------");
                    Log.i(TAG, result.toString());
                    Log.i(TAG, "---------------------------------------------------------");
                }

                Message msg = alipayHandler.obtainMessage();
                msg.what = WHAT_ALIPAY_RESULT;
                msg.obj = result;
                alipayHandler.sendMessage(msg);
            }
        }).start();
    }

    public interface OnAlipayCallback {
        void onSuccess(String result);

        void onFail(String error);
    }
}
