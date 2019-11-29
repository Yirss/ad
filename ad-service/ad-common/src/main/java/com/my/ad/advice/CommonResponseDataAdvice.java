package com.my.ad.advice;

import com.my.ad.annotation.IgnoreRespnonseAdive;
import com.my.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName CommonResponseDataAdvice
 * @Deseription
 * @Author ywk
 * @Date 2019/11/29 12:34
 * @Version 1.0
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreRespnonseAdive.class)) {
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(IgnoreRespnonseAdive.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        CommonResponse<Object> response = new CommonResponse<>(0,"");
        if(null == body){
            return response;
        }else if(body instanceof CommonResponse){
            response = (CommonResponse<Object>) body;
        }else {
            response.setData(body);
        }
        return response;
    }
}
