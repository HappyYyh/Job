package com.yyh.job.dto.request.resume;

import lombok.Data;

import java.util.List;

/**
 * @Package com.yyh.job.dto.request.resume
 * @author: 昊天
 * @date: 2019-04-17 21:03
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class AddResumeRequest {

    /**
     * 基础信息
     */
    ResumeBaseRequest baseRequest;

    /**
     * 教育信息
     */
    List<ResumeEducationRequest> educationRequestList;

    /**
     * 工作经验
     */
    List<ResumeExperienceRequest> experienceRequestList;

    /**
     * 项目经验
     */
    List<ResumeProjectRequest> projectRequestList;
}
