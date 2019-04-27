package com.yyh.job.dto.response.job;

import lombok.Data;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.response
 * @author: 昊天
 * @date: 2019-03-28 21:51
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class JobSecondCategoryResponse {

    /**
     * 职业二级名称
     */
    private String secondName;

    /**
     * 职业二级id
     */
    private String secondId;


    private List<JobThirdCategoryResponse> jobThirdCategoryResponseList;
}
