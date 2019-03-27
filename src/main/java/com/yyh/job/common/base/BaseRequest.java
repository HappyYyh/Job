package com.yyh.job.common.base;

import lombok.Data;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.cjs.question.common.base
 * @author: 昊天
 * @date: 2019-03-06 13:45
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class BaseRequest {

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每夜条数
     */
    private Integer pageSize;
}
