package com.yyh.job.dto.response;

import lombok.Data;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.response
 * @author: 昊天
 * @date: 2019-03-28 21:50
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class JobFirstCategoryResponse {

    /**
     * 职业一级名称
     */
    private String firstName;

    /**
     * 职业一级id
     */
    private String firstId;

    private List<JobSecondCategoryResponse> jobSecondCategoryResponseList;
}
