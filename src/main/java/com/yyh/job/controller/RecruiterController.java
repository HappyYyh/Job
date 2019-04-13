package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dto.request.BindCompanyRequest;
import com.yyh.job.dto.request.CommonRecruiterRequest;
import com.yyh.job.dto.request.RecruiterListRequest;
import com.yyh.job.service.RecruiterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-12 22:11
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "RecruiterController",description = "公司招聘者")
@RequestMapping("/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/bindCompany")
    @AuthToken
    public APIResult bindCompany(@RequestBody @Valid BindCompanyRequest request, BindingResult bindingResult){
        return recruiterService.bindCompany(request);
    }

    @PostMapping("/getRecruiters")
    @AuthToken
    public APIResult getRecruiters(@RequestBody @Valid RecruiterListRequest request, BindingResult bindingResult){
        return recruiterService.getRecruiters(request);
    }

    @PostMapping("/updateRecruiterInfo")
    @AuthToken
    public APIResult updateRecruiterInfo(@RequestBody @Valid CommonRecruiterRequest request, BindingResult bindingResult){
        return recruiterService.updateRecruiterInfo(request);
    }
}
