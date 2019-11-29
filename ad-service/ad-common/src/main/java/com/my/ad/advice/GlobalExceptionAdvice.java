package com.my.ad.advice;

import com.my.ad.exception.AdException;
import com.my.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionAdvice
 * @Deseription
 * @Author ywk
 * @Date 2019/11/29 13:01
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handleAdException(HttpServletRequest request, AdException ex) {
        return new CommonResponse<String>(-1, "business error", ex.getMessage());
    }
}
