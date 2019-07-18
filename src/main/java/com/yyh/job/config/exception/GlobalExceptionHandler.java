package com.yyh.job.config.exception;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @Package com.yyh.job.exception..config
 * @author: 昊天
 * @date: 2019-03-27 15:01
 * @since V1.1.0-SNAPSHOT
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIResult exception(Exception e) {
        log.error("拦截到异常：{}",e.getMessage());
        e.printStackTrace();
        return APIResult.error(BaseEnum.ERROR);
    }

    /**
     * 参数绑定异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIResult bindErrorException(BindErrorException e) {
        return APIResult.error(String.valueOf(BaseEnum.PARAM_HAS_ERROR.getCode()),e.getMessage());
    }

    /**
     * 权限异常
     * @param e
     * @return
     */
    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public APIResult PermissionException(PermissionException e) {
        return APIResult.error("403",e.getMessage());
    }

}
