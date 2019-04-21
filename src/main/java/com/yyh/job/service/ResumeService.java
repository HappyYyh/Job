package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.ResumeDeleteRequest;
import com.yyh.job.dto.request.resume.*;

import java.util.List;

/**
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-04-17 21:30
 * @since V1.1.0-SNAPSHOT
 */
public interface ResumeService {

    /**
     * 新增简历
     * @param request
     * @return
     */
    APIResult addResume(AddResumeRequest request);

    /**
     * 新增简历基础信息
     * @param request
     * @return
     */
    APIResult submitBase(ResumeBaseRequest request);

    /**
     * 修改基础简历信息
     * @param request
     * @return
     */
    //APIResult editBase(ResumeBaseRequest request);

    /**
     * 新增/修改简历教育信息
     * @param request
     * @return
     */
    APIResult submitEducation(ResumeEducationRequest request);

    /**
     * 新增简历工作经验
     * @param request
     * @return
     */
    APIResult submitExperience(ResumeExperienceRequest request);

    /**
     * 新增简历项目信息
     * @param request
     * @return
     */
    APIResult submitProject(ResumeProjectRequest request);


    /**
     * 查看我的简历
     * @param userId
     * @return
     */
    APIResult getResume(Integer userId);

    /**
     * 删除简历信息
     * @param request
     * @return
     */
    APIResult delete(ResumeDeleteRequest request);
}
