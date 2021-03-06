package com.yyh.job.dto.request.resume;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Package com.yyh.job.dto.request.resume
 * @author: 昊天
 * @date: 2019-04-17 21:01
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeProjectRequest {

    private Integer id;

    /**
     * 简历基础的id
     */
    @NotNull
    private Integer resumeId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 开始时间
     */
    @Length(min = 7,max = 7,message = "日期不规范")
    private String startTime;

    /**
     * 结束时间
     */
    @Length(min = 7,max = 7,message = "日期不规范")
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
