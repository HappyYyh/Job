package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.resume.AddResumeRequest;
import com.yyh.job.service.ResumeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-17 21:26
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "ResumeController",description = "简历")
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/add")
    public APIResult addResume(@RequestBody @Valid AddResumeRequest request, BindingResult bindingResult){
        return resumeService.addResume(request);
    }
}
