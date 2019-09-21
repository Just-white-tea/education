package com.vip.account.utils.exception;


import com.vip.account.utils.ResponseStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义全局异常处理类
 *
 * @author zhangwei
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {

    private ResponseStatus status;

    public ServiceException(ResponseStatus responseStatus) {
        this.status = responseStatus;
    }

    public ServiceException(Throwable cause, ResponseStatus responseStatus) {
        super(cause);
        this.status = responseStatus;
    }
}