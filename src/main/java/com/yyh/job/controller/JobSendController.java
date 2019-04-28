package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dto.request.job.CommonJobSendRequest;
import com.yyh.job.service.JobSendService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-28 20:59
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "JobSendController",description = "职位投递")
@RequestMapping("/jobSend")
public class JobSendController {

    @Autowired
    private JobSendService jobSendService;

    @PostMapping("/add")
    @AuthToken
    public APIResult addSend(@RequestBody CommonJobSendRequest request){
        return jobSendService.addSend(request);
    }

    @PostMapping("/isSend")
    public APIResult isSend(@RequestBody CommonJobSendRequest request){
        return jobSendService.isSend(request);
    }
}
