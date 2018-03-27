package com.chan.rize.generalcode.model.web.dictionary;

import com.chan.rize.generalcode.model.web.request.BaseRequest;
import com.chan.rize.generalcode.model.web.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by rize on 2018/03/23.
 *
 * @description
 */
public interface ApiService {

    /**
     * 请求服务器接口
     */
    @POST("/api/url/")
    Call<BaseResponse> getAppInfo(@Body BaseRequest request);
}