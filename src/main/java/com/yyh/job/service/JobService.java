package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.CommonJobRequest;
import com.yyh.job.dto.request.QueryJobRequest;

/**
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-04-14 09:49
 * @since V1.1.0-SNAPSHOT
 */
public interface JobService {

    /**
     * 发布职位
     * @param request
     * @return
     */
    APIResult addJob(CommonJobRequest request);

    /**
     * 查找招聘者发布的职位
     * @param request
     * @return
     */
    APIResult getJobList(QueryJobRequest request);
}
