package com.chan.rize.generalcode.model.web.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 2018/3/23.
 */

public class BaseResponse {

    @SerializedName("code")
    private String responseCode;
    private String responseDesc;
    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }
}
