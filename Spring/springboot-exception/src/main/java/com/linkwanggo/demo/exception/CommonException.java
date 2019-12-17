package com.linkwanggo.demo.exception;

import com.linkwanggo.demo.model.response.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommonException extends RuntimeException {

    private ExceptionCode exceptionCode;

    public CommonException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
