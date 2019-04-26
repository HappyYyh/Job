package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dto.request.job.CommonJobRequest;
import com.yyh.job.dto.request.job.QueryJobRequest;
import com.yyh.job.service.JobService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-14 09:50
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "JobController",description = "职位")
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/add")
    @AuthToken
    public APIResult addJob(@RequestBody @Valid CommonJobRequest request, BindingResult bindingResult){
        return jobService.addJob(request);
    }

    @GetMapping("/detail")
    @AuthToken
    public APIResult detail(Integer id){
        return jobService.detail(id);
    }

    @PostMapping("/update")
    @AuthToken
    public APIResult update(@RequestBody @Valid CommonJobRequest request, BindingResult bindingResult){
        return jobService.update(request);
    }

    /**
     * 招聘者查看自己发布的职位
     * @param request
     * @return
     */
    @PostMapping("/getJobList")
    @AuthToken
    public APIResult getJobList(@RequestBody  QueryJobRequest request){
        return jobService.getJobList(request);
    }

    /**
     * 公共查询
     */
    @PostMapping("/list")
    public APIResult queryJobList(@RequestBody QueryJobRequest request){
        return jobService.queryJobList(request);
    }


}
