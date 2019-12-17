package com.linkwanggo.demo.advice;

import com.google.common.collect.ImmutableMap;
import com.linkwanggo.demo.exception.CommonException;
import com.linkwanggo.demo.model.response.ExceptionCode;
import com.linkwanggo.demo.model.response.ExceptionResult;
import com.linkwanggo.demo.model.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    //使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //使用builder来构建一个异常类型和错误代码的异常
    private static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    static {
        // spring的内部异常类与自定义异常的对应关系
        builder.put(HttpMessageNotReadableException.class, ExceptionCode.INVALID_PARAM);
        builder.put(MethodArgumentTypeMismatchException.class, ExceptionCode.PARAM_CAST_ERROR);
    }

    /**
     * 不可预知异常捕获
     * @param e Exception
     * @return ResponseEntity<ExceptionResult>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResult> handleRestException(Exception e) {
        log.error("catch exception : {}\r\nexception: {}",e.getMessage(), e);
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        ExceptionResult exceptionResult;
        ResultCode resultCode;
        resultCode = EXCEPTIONS.get(e.getClass());
        if (resultCode != null) {
            exceptionResult = new ExceptionResult(resultCode);
            return ResponseEntity.status(resultCode.getStatus()).body(exceptionResult);
        } else {
            exceptionResult = new ExceptionResult(ExceptionCode.SERVER_ERROR);
            return ResponseEntity.status(500).body(exceptionResult);
        }
    }

    /**
     * 可预知异常捕获
     * @param ce CommonException
     * @return ResponseEntity<ExceptionResult>
     */
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ExceptionResult> handleRestCommonException(CommonException ce) {
        log.error("catch exception : {}\r\nexception: {}",ce.getMessage(), ce);
        ExceptionCode exceptionCode = ce.getExceptionCode();
        return ResponseEntity.status(exceptionCode.getStatus()).body(new ExceptionResult(exceptionCode));
    }
}
