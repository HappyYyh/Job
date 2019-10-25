package com.yyh.job.config.exception;

/**
 * All rights Reserved, Designed By yyh
 *
 * @Package com.yyh.job.config.exception
 * @author: yyh
 * @date: 2019/7/18 14:03
 * @since V1.1.0-SNAPSHOT
 */
public class PermissionException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public PermissionException(String message) {
        super(message);
    }

}
