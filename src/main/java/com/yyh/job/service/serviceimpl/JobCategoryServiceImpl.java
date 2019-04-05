package com.yyh.job.service.serviceimpl;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dao.mapper.JobFirstMapper;
import com.yyh.job.dto.response.JobFirstCategoryResponse;
import com.yyh.job.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-03-28 22:13
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    private JobFirstMapper jobFirstMapper;

    /**
     * 获取所有的职位分类
     *
     * @return
     */
    @Override
    public APIResult<List<JobFirstCategoryResponse>> getAllCategory() {
        return APIResult.create(jobFirstMapper.selectAllCategory());
    }
}
