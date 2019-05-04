package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dto.request.job.CommonJobSubScribeRequest;
import com.yyh.job.service.JobSubScribeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-30 22:45
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "JobSubScribeController",description = "职位订阅")
@RequestMapping("/jobSubScribe")
public class JobSubScribeController {

    @Autowired
    private JobSubScribeService jobSubScribeService;

    @PostMapping("/add")
    @AuthToken
    public APIResult add(@RequestBody CommonJobSubScribeRequest request){
        return jobSubScribeService.add(request);
    }

    @PostMapping("/update")
    @AuthToken
    public APIResult update(@RequestBody CommonJobSubScribeRequest request){
        return jobSubScribeService.update(request);
    }

    @GetMapping("/delete")
    @AuthToken
    public APIResult delete(Integer id){
        return jobSubScribeService.delete(id);
    }

    @GetMapping("/get")
    @AuthToken
    public APIResult get(Integer userId){
        return jobSubScribeService.getMySubScribe(userId);
    }
}
