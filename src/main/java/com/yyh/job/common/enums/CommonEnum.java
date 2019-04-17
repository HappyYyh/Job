package com.yyh.job.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.file.enums
 * @author: 昊天
 * @date: 2019-03-05 16:59
 * @since V1.1.0-SNAPSHOT
 */
@AllArgsConstructor
public enum CommonEnum {

    /**
     * 一些常用的数字
     */
    ZERO(0),
    ONE(1),
    TWO(2),
    TEN(10),
    HUNDRED(100);

    @Getter
    private Integer code;


}
