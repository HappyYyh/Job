package com.yyh.job.dto.response.job;

import lombok.Data;

import java.util.Date;

/**
 * @Package com.yyh.job.dto.response.job
 * @author: 昊天
 * @date: 2019-04-29 21:42
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class SeekerSendListResponse {

    /**
     * 职位id
     */
    private Integer jobId;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 薪水起始
     */
    private Double salaryStart;

    /**
     * 薪水结束
     */
    private Double salaryEnd;

    /**
     * 工作地点
     */
    private String workPlace;

    /**
     * 城市
     */
    private String city;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 展示时间
     */
    private String showTime;

    /**
     * 状态
     */
    private Integer sendStatus;

}
