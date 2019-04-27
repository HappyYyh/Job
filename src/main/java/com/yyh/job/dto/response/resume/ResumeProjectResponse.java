package com.yyh.job.dto.response.resume;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.response.resume
 * @author: 昊天
 * @date: 2019-04-20 14:02
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeProjectResponse {

    private Integer id;

    /**
     * 简历基础的id
     */
    private Integer resumeId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 项目成就
     */
    private String result;
}
