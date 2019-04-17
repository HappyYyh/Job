package com.yyh.job.service.serviceimpl;

import com.google.common.collect.Lists;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.ResumeBaseMapper;
import com.yyh.job.dao.mapper.ResumeEducationMapper;
import com.yyh.job.dao.mapper.ResumeExperienceMapper;
import com.yyh.job.dao.mapper.ResumeProjectMapper;
import com.yyh.job.dao.model.ResumeBase;
import com.yyh.job.dao.model.ResumeEducation;
import com.yyh.job.dao.model.ResumeExperience;
import com.yyh.job.dao.model.ResumeProject;
import com.yyh.job.dto.request.resume.*;
import com.yyh.job.service.ResumeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-04-17 21:31
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeBaseMapper resumeBaseMapper;

    @Autowired
    private ResumeEducationMapper resumeEducationMapper;

    @Autowired
    private ResumeExperienceMapper resumeExperienceMapper;

    @Autowired
    private ResumeProjectMapper resumeProjectMapper;

    /**
     * 新增简历
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult addResume(AddResumeRequest request) {
        ResumeBaseRequest baseRequest = request.getBaseRequest();
        ResumeBase resumeBase = new ResumeBase();
        BeanUtils.copyProperties(baseRequest,resumeBase);
        //首先插入基础的信息
        int insertBase = resumeBaseMapper.insert(resumeBase);
        if(CommonEnum.ONE.getCode().equals(insertBase)){
            //获取生成的主键id
            Integer resumeId = resumeBase.getId();

            //构建简历教育信息
            List<ResumeEducationRequest> educationRequestList = request.getEducationRequestList();
            List<ResumeEducation> educationList = Lists.newArrayList();
            educationRequestList.forEach(resumeEducationRequest -> {
                ResumeEducation resumeEducation = new ResumeEducation();
                resumeEducation.setResumeId(resumeId);
                BeanUtils.copyProperties(resumeEducationRequest,resumeEducation);
                educationList.add(resumeEducation);
            });

            //构建简历工作经验信息信息
            List<ResumeExperienceRequest> resumeExperienceRequestList = request.getExperienceRequestList();
            List<ResumeExperience> experienceList = Lists.newArrayList();
            resumeExperienceRequestList.forEach(resumeExperienceRequest ->{
                ResumeExperience resumeExperience = new ResumeExperience();
                resumeExperience.setResumeId(resumeId);
                BeanUtils.copyProperties(resumeExperienceRequest,resumeExperience);
                experienceList.add(resumeExperience);
            });

            //构建简历教育信息
            List<ResumeProjectRequest> resumeProjectRequestList = request.getProjectRequestList();
            List<ResumeProject> projectList = Lists.newArrayList();
            resumeProjectRequestList.forEach(resumeProjectRequest ->  {
                ResumeProject resumeProject = new ResumeProject();
                resumeProject.setResumeId(resumeId);
                BeanUtils.copyProperties(resumeProjectRequest,resumeProject);
                projectList.add(resumeProject);
            });

            //批量插入
            resumeEducationMapper.batchInsert(educationList);
            resumeExperienceMapper.batchInsert(experienceList);
            resumeProjectMapper.batchInsert(projectList);
        }
        return APIResult.ok();
    }
}
