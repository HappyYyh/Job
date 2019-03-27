package com.yyh.job.config.exception;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 * 参数绑定异常
 * @Package com.yyh.job.config
 * @author: 昊天
 * @date: 2019-03-20 13:42
 * @since V1.1.0-SNAPSHOT
 */
public class BindErrorException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BindErrorException(String message) {
        super(message);
    }
}
