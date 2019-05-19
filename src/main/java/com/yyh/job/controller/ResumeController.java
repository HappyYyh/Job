package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dto.request.resume.ResumeDeleteRequest;
import com.yyh.job.dto.request.resume.*;
import com.yyh.job.service.ResumeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addALL")
    @Deprecated
    public APIResult addResume(@RequestBody @Valid AddResumeRequest request, BindingResult bindingResult){
        return resumeService.addResume(request);
    }

    /**
     * 用户查看自己的简历
     * @param userId
     * @return
     */
    @GetMapping("/getResume")
    @AuthToken
    public APIResult getResume(Integer userId){
        return resumeService.getResume(userId);
    }

    @PostMapping("/recruiterGet")
    public APIResult recruiterGet(@RequestBody RecruiterReviewResumeRequest request){
        return resumeService.recruiterGet(request);
    }

    @PostMapping("/deleteResume")
    @AuthToken
    public APIResult deleteResume(@RequestBody @Valid ResumeDeleteRequest request, BindingResult bindingResult){
        return resumeService.delete(request);
    }

    @PostMapping("/submitBase")
    @AuthToken
    public APIResult submitBase(@RequestBody @Valid ResumeBaseRequest request, BindingResult bindingResult){
        return resumeService.submitBase(request);
    }

    @PostMapping("/submitEducation")
    @AuthToken
    public APIResult submitEducation(@RequestBody @Valid ResumeEducationRequest request, BindingResult bindingResult){
        return resumeService.submitEducation(request);
    }

    @PostMapping("/submitExperience")
    @AuthToken
    public APIResult submitExperience(@RequestBody @Valid ResumeExperienceRequest request, BindingResult bindingResult){
        return resumeService.submitExperience(request);
    }

    @PostMapping("/submitProject")
    @AuthToken
    public APIResult submitProject(@RequestBody @Valid ResumeProjectRequest request, BindingResult bindingResult){
        return resumeService.submitProject(request);
    }

    @PostMapping("/addOtherResume")
    @AuthToken
    public APIResult addOtherResume(@RequestBody @Valid AddOtherResumeRequest request, BindingResult bindingResult){
        return resumeService.addOtherResume(request);
    }

    @GetMapping("/deleteOtherResume")
    @AuthToken
    public APIResult deleteOtherResume(Integer id) {
        return resumeService.deleteOtherResume(id);
    }
}
