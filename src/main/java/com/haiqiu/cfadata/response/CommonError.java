package com.haiqiu.cfadata.response;

/**
 * Created by peanut on 2019/3/23 下午6:01
 */
public interface CommonError {
    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);
}
