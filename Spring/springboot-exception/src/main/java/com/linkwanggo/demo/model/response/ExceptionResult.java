package com.linkwanggo.demo.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ExceptionResult {

    private boolean success;

    private int code;

    private String message;

    private Long timestamp;

    public ExceptionResult(ResultCode exceptionCode) {
        this.success = exceptionCode.isSuccess();
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
        this.timestamp = System.currentTimeMillis();
    }
}
