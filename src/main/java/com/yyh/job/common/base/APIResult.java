package com.yyh.job.common.base;


import com.yyh.job.common.enums.BaseEnum;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.cjs.question.common
 * @author: 昊天
 * @date: 2019-03-05 15:59
 * @since V1.1.0-SNAPSHOT
 */
public class APIResult<T> implements Serializable {

    private boolean success = false;
    private String code;
    private String message;
    private T data;

    public APIResult() {
    }

    public APIResult(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static APIResult ok() {
        APIResult result = new APIResult();
        result.setSuccess(true);
        result.setCode("200");
        return result;
    }

    public static APIResult error() {
        APIResult result = new APIResult();
        result.setSuccess(false);
        result.setCode("500");
        return result;
    }

    public static APIResult error(String code, String msg) {
        APIResult result = new APIResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static APIResult error(BaseEnum baseEnum) {
        APIResult result = new APIResult();
        result.setSuccess(false);
        result.setCode(String.valueOf(baseEnum.getCode()));
        result.setMessage(baseEnum.getMsg());
        return result;
    }

    public static <T> APIResult <T> error(BaseEnum baseEnum,T data) {
        APIResult result = new APIResult();
        result.setSuccess(false);
        result.setCode(String.valueOf(baseEnum.getCode()));
        result.setMessage(baseEnum.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> APIResult<T> create() {
        return new APIResult();
    }

    public static <T> APIResult<T> create(T data) {
        APIResult<T> result = create();
        result.setSuccess(true);
        result.setData(data);
        result.setCode("200");
        return result;
    }

    public static <T> APIResult<T> create(T data, String code, String message) {
        APIResult<T> result = create();
        result.setSuccess(true);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> APIResult<T> create(T data, boolean isSuccess, String code, String message) {
        APIResult<T> result = create();
        result.setSuccess(isSuccess);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> APIResult<T> create(String code, String message) {
        APIResult<T> result = create();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> APIResult<T> create(BaseEnum baseEnum) {
        APIResult<T> result = create();
        result.setSuccess(false);
        result.setCode(String.valueOf(baseEnum.getCode()));
        result.setMessage(baseEnum.getMsg());
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
