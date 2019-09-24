package com.vip.order.utils.exception;

import com.vip.order.utils.ResponseStatus;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ServiceException extends Exception{
    private ResponseStatus status;

    public ServiceException(ResponseStatus responseStatus) {
        this.status = responseStatus;
    }

    public ServiceException(Throwable cause, ResponseStatus responseStatus) {
        super(cause);
        this.status = responseStatus;
    }
}
