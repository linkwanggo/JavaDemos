package com.linkwanggo.demo.model.response;

public interface ResultCode {
    //操作是否成功,true为成功，false操作失败
    boolean isSuccess();
    // 造作状态码
    int getStatus();
    //操作返回代码
    int getCode();
    //提示信息
    String getMessage();
}
