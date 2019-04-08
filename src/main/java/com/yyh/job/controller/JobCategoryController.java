package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dto.response.JobFirstCategoryResponse;
import com.yyh.job.service.JobCategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-03-28 21:24
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "JobCategoryController",description = "职位分类")
@RequestMapping("/jobCategory")
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @GetMapping("/getAllCategory")
    @AuthToken
    public APIResult<List<JobFirstCategoryResponse>> getAllCategory(){
        return jobCategoryService.getAllCategory();
    }
}
