package com.yyh.job.common.base;

import java.lang.annotation.*;

/**
 * All rights Reserved, Designed By yyh
 *
 * @Package com.yyh.job.common.base
 * @author: yyh
 * @date: 2019/7/17 15:46
 * @since V1.1.0-SNAPSHOT
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    /**
     * 权限名称
     * @return
     */
    String[] value() default {};
}
