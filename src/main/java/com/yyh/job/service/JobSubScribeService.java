package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.job.CommonJobSubScribeRequest;

/**
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-04-30 22:40
 * @since V1.1.0-SNAPSHOT
 */
public interface JobSubScribeService {

    /**
     * 新增
     * @param request
     * @return
     */
    APIResult add(CommonJobSubScribeRequest request);

    /**
     * 查询我的订阅
     * @param userId
     * @return
     */
    APIResult getMySubScribe(Integer userId);

    /**
     * 修改
     * @param request
     * @return
     */
    APIResult update(CommonJobSubScribeRequest request);

    /**
     * 删除
     * @param id
     * @return
     */
    APIResult delete(Integer id);
}
