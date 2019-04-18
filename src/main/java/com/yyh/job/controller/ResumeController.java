package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.resume.*;
import com.yyh.job.service.ResumeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/addALL")
    @Deprecated
    public APIResult addResume(@RequestBody @Valid AddResumeRequest request, BindingResult bindingResult){
        return resumeService.addResume(request);
    }

    @PostMapping("/addBase")
    public APIResult addBase(@RequestBody @Valid ResumeBaseRequest request, BindingResult bindingResult){
        return resumeService.addBase(request);
    }

    @PostMapping("/addEducation")
    public APIResult addEducation(@RequestBody @Valid List<ResumeEducationRequest> request, BindingResult bindingResult){
        return resumeService.addEducation(request);
    }

    @PostMapping("/addExperience")
    public APIResult addExperience(@RequestBody @Valid List<ResumeExperienceRequest> request, BindingResult bindingResult){
        return resumeService.addExperience(request);
    }

    @PostMapping("/addProject")
    public APIResult addProject(@RequestBody @Valid List<ResumeProjectRequest> request, BindingResult bindingResult){
        return resumeService.addProject(request);
    }
}
