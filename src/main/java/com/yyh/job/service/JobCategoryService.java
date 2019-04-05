package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.response.JobFirstCategoryResponse;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-03-28 22:12
 * @since V1.1.0-SNAPSHOT
 */
public interface JobCategoryService {

    /**
     * 获取所有的职位分类
     * @return
     */
    APIResult<List<JobFirstCategoryResponse>> getAllCategory();
}
