package com.chan.rize.generalcode.model.web;

import com.chan.rize.generalcode.utils.LogUtil;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.chan.rize.generalcode.model.web.WebConst.BASE_URL;
import static com.chan.rize.generalcode.model.web.WebConst.TIME_OUT_VALUE;

/**
 * Created by user on 2018/3/23.
 */

public class ApiServiceFactory {

    private static OkHttpClient getOkHttpClient() {
        LogUtil.i("getOkHttpClient");
        //设置https 安全证书
//        HttpsUtil.SSLParams sslParams = HttpsUtil.getSslSocketFactory(HttpsUtil.setSsl(MainApplication.getContext()), null, null);
        return new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT_VALUE, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT_VALUE, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT_VALUE, TimeUnit.MILLISECONDS)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
//                .addInterceptor(getHeadInterceptor())
//                .addInterceptor(getLogInterceptor())// 增加过滤器
                .build();
    }

    public static Retrofit getRetrofit() {
        /********************配置网络环境BaseHost地址********************/
        String url = BASE_URL;
        return new Retrofit.Builder()
                //设置OKHttpClient,如果不设置会提供一个默认的
                .client(getOkHttpClient())
                .baseUrl(url)
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
