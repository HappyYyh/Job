package com.yyh.job.common.enums;

import lombok.Getter;

/**
 * @Package com.yyh.job.common.enums
 * @author: 昊天
 * @date: 2019-04-30 19:43
 * @since V1.1.0-SNAPSHOT
 */
public enum  RoleEnum {

    /**
     * 身份枚举
     */
    SEEKER(0,"求职者"),
    RECRUITER(1,"招聘者");

    @Getter
    private Integer code;
    @Getter
    private String  msg;

    RoleEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
