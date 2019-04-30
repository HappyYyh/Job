package com.yyh.job.dto.response.job;

import lombok.Data;

import java.util.List;

/**
 * @Package com.yyh.job.dto.response.job
 * @author: 昊天
 * @date: 2019-04-30 11:43
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class RecruiterGotListResponse {

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
     * 求职者基础显示信息;
     */
    private List<SeekerInfoResponse> seekerInfoResponseList;

}
