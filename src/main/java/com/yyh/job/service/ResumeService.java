package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.resume.AddResumeRequest;

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
}
