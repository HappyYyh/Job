package com.yyh.job.dto.response.resume;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.response.resume
 * @author: 昊天
 * @date: 2019-04-20 14:00
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeExperienceResponse {

    private Integer id;

    /**
     * 简历基础的id
     */
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
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 详细描述
     */
    private String detail;
}
