package com.linkwanggo.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionCode implements ResultCode {

    SERVER_ERROR(false, 500, 10000, "意料之外的异常"),
    FAIL(false, 400, 10001, "操作失败"),
    INVALID_PARAM(false, 400, 10003, "请求参数异常"),
    PARAM_CAST_ERROR(false, 400, 1000, "请求参数转换异常"),
    ;

    boolean success;

    int status;

    int code;

    String message;

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
