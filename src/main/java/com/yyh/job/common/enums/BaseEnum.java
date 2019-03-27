package com.yyh.job.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.cjs.question.common.enums
 * @author: 昊天
 * @date: 2019-03-05 17:04
 * @since V1.1.0-SNAPSHOT
 */
@AllArgsConstructor
public enum BaseEnum {

    /**
     *  基础的枚举
     */
    SUCCESS(200,""),
    ERROR(500,"Internal Server Error"),

    PARAM_HAS_ERROR(501,"参数错误!"),
    ;

    @Getter
    private Integer code;
    @Getter
    private String msg;
}
