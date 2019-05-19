package com.yyh.job.dto.response.resume;

import lombok.Data;

import java.util.List;

/**
 * @Package com.yyh.job.dto.response.resume
 * @author: 昊天
 * @date: 2019-04-20 14:03
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class MyResumeResponse {

    /**
     * 基础信息
     */
    private ResumeBaseResponse resumeBaseResponse;

    /**
     * 教育信息
     */
    private List<ResumeEducationResponse> resumeEducationResponseList;

    /**
     * 工作经验
     */
    private List<ResumeExperienceResponse> resumeExperienceResponseList;

    /**
     * 项目经验
     */
    private List<ResumeProjectResponse> resumeProjectResponseList;

    /**
     * 三方简历信息
     */
    private List<ResumeOtherResponse>  resumeOtherResponseList;
}
