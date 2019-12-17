package com.haiqiu.cfadata.response;

/**
 * Created by peanut on 2019/3/23 下午6:22
 */
public class BizException extends Exception implements CommonError {

    private CommonError commonError;

    //super关键字调用父类的构造方法，不写super也会默认在第一行调用父类的构造方法
    public BizException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BizException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        return commonError.setErrMsg(errMsg);
    }
}
