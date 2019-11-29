package com.my.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CommonResponse
 * @Deseription 统一响应
 * @Author ywk
 * @Date 2019/11/29 12:31
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 793066547971574624L;

    private Integer code;

    private String message;

    private T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
