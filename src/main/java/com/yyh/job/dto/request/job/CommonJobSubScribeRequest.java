package com.yyh.job.dto.request.job;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.request.job
 * @author: 昊天
 * @date: 2019-04-30 22:39
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class CommonJobSubScribeRequest {

    private Integer id;

    /**
     * 职位分类
     */
    private String jobCategory;

    /**
     * 城市
     */
    private String workCity;

    /**
     * 订阅者id
     */
    private Integer userId;
}
