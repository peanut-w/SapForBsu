package com.haiqiu.cfadata.response;


/**
 * Created by peanut on 2019/3/23 下午6:09
 */
public enum ErrorEnum implements CommonError {
    //自定义一些错误的枚举类型
    NOT_EXISTS(10001, "空");
    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    ErrorEnum(int errCode, String errMsg) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }
}
