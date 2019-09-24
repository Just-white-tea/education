package com.vip.order.utils;

import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder
public class ErrorResponseEntity implements BaseResponseEntity{
    /**
     * HTTP响应状态码 {@link org.springframework.http.HttpStatus}
     */
    private Integer status;

    /**
     * 前端显示的信息
     */
    private String msg;
    /**
     * 错误的信息
     */
    private String error;
    /**
     * 异常的名字
     */
    private String exception;

    private String path;

    /**
     * 时间戳
     */
    private Date timestamp;
    public static ErrorResponseEntity failure(ResponseStatus responseStatus, Throwable e) {
        return ErrorResponseEntity.builder()
                .msg(responseStatus.getMsg())
                .status(responseStatus.getStatus())
                .error(e.getMessage())
                .timestamp(new Date())
                .exception(e.getClass().getName())
                .build();
    }

}
