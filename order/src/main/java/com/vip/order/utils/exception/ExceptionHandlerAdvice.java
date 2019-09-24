package com.vip.order.utils.exception;


import com.vip.order.utils.BaseResponseEntity;
import com.vip.order.utils.ResponseEntity;
import com.vip.order.utils.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public BaseResponseEntity handleException(Exception e) {
        if (e instanceof ServiceException) {
            return ResponseEntity.error(ResponseStatus.BUSINESS_UNKNOW_ERROR);
        } else if (e instanceof NoHandlerFoundException) {
            return ResponseEntity.error(ResponseStatus.NO_FOUND_ERROR);
        } else {
            return ResponseEntity.error(ResponseStatus.SYSTEM_UNKNOW_ERROR);
        }
    }
}
