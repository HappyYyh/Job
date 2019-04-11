package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dto.request.CommonCompanyRequest;
import com.yyh.job.service.CompanyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-07 22:33
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "CompanyController",description = "企业")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/certificate")
    @AuthToken
    public APIResult certificate(@RequestBody @Valid CommonCompanyRequest request, BindingResult bindingResult){
        return companyService.certificate(request);
    }

    @GetMapping("/info")
    @AuthToken
    public APIResult info(Integer recruiterId){
        return companyService.getCompanyInfo(recruiterId);
    }
}
