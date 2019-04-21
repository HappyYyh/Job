package com.yyh.job.dto.request.resume;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * @Package com.yyh.job.dto.request.resume
 * @author: 昊天
 * @date: 2019-04-17 20:59
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeExperienceRequest {

    private Integer id;

    /**
     * 简历基础的id
     */
    @NotNull
    private Integer resumeId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 岗位
     */
    private String position;

    /**
     * 职位名称
     */
    private String job;

    /**
     * 开始时间(形如 ：2018-05-01)
     */
    @Length(min = 10,max = 10,message = "日期不规范")
    private String startTime;

    /**
     * 结束时间
     */
    @Length(min = 10,max = 10,message = "日期不规范")
    private String endTime;

    /**
     * 详细描述
     */
    private String detail;
}
