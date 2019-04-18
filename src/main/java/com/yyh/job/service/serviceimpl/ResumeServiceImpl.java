package com.yyh.job.service.serviceimpl;

import com.google.common.collect.Lists;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
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
    @Deprecated
    public APIResult addResume(AddResumeRequest request) {
        ResumeBaseRequest baseRequest = request.getBaseRequest();
        ResumeBase resumeBase = new ResumeBase();
        BeanUtils.copyProperties(baseRequest,resumeBase);
        //首先插入基础的信息
        int insertBase = resumeBaseMapper.insert(resumeBase);
        if(CommonEnum.ONE.getCode().equals(insertBase)) {
            //获取生成的主键id
            Integer resumeId = resumeBase.getId();

            //构建简历教育信息
            List<ResumeEducationRequest> educationRequestList = request.getEducationRequestList();
            List<ResumeEducation> educationList = Lists.newArrayList();
            for (ResumeEducationRequest educationRequest : educationRequestList) {
                ResumeEducation resumeEducation = new ResumeEducation();
                resumeEducation.setResumeId(resumeId);
                BeanUtils.copyProperties(educationRequest, resumeEducation);
                educationList.add(resumeEducation);
            }

            //构建简历工作经验信息信息
            List<ResumeExperienceRequest> resumeExperienceRequestList = request.getExperienceRequestList();
            List<ResumeExperience> experienceList = Lists.newArrayList();
            for (ResumeExperienceRequest experienceRequest : resumeExperienceRequestList){
                ResumeExperience resumeExperience = new ResumeExperience();
                resumeExperience.setResumeId(resumeId);
                BeanUtils.copyProperties(experienceRequest, resumeExperience);
                experienceList.add(resumeExperience);
            }

            //构建简历教育信息
            List<ResumeProjectRequest> resumeProjectRequestList = request.getProjectRequestList();
            List<ResumeProject> projectList = Lists.newArrayList();
            for(ResumeProjectRequest projectRequest :resumeProjectRequestList){
                ResumeProject resumeProject = new ResumeProject();
                resumeProject.setResumeId(resumeId);
                BeanUtils.copyProperties(projectRequest,resumeProject);
                projectList.add(resumeProject);
            }


            //批量插入
            resumeEducationMapper.batchInsert(educationList);
            resumeExperienceMapper.batchInsert(experienceList);
            resumeProjectMapper.batchInsert(projectList);
        }
        return APIResult.ok();
    }

    /**
     * 新增简历基础信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult addBase(ResumeBaseRequest request) {
        ResumeBase resumeBase = new ResumeBase();
        BeanUtils.copyProperties(request,resumeBase);
        //首先插入基础的信息
        int insertBase = resumeBaseMapper.insert(resumeBase);
        if(CommonEnum.ONE.getCode().equals(insertBase)) {
            //获取生成的主键id
            Integer resumeId = resumeBase.getId();
            return APIResult.create(resumeId);
        }
        return APIResult.error(BaseEnum.ADD_RESUME_BASE_ERROR);
    }

    /**
     * 新增简历教育信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult addEducation(List<ResumeEducationRequest> request) {
        Integer resumeId = request.get(0).getResumeId();
        //构建简历教育信息
        List<ResumeEducation> educationList = Lists.newArrayList();
        request.forEach(resumeEducationRequest -> {
            ResumeEducation resumeEducation = new ResumeEducation();
            resumeEducation.setResumeId(resumeId);
            BeanUtils.copyProperties(resumeEducationRequest,resumeEducation);
            educationList.add(resumeEducation);
        });
        resumeEducationMapper.batchInsert(educationList);
        return APIResult.ok();
    }

    /**
     * 新增简历工作经验
     *
     * @param request
     * @return
     */
    @Override
    public APIResult addExperience(List<ResumeExperienceRequest> request) {
        Integer resumeId = request.get(0).getResumeId();
        //构建简历工作经验信息信息
        List<ResumeExperience> experienceList = Lists.newArrayList();
        request.forEach(resumeExperienceRequest ->{
            ResumeExperience resumeExperience = new ResumeExperience();
            resumeExperience.setResumeId(resumeId);
            BeanUtils.copyProperties(resumeExperienceRequest,resumeExperience);
            experienceList.add(resumeExperience);
        });
        resumeExperienceMapper.batchInsert(experienceList);
        return APIResult.ok();
    }

    /**
     * 新增简历项目信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult addProject(List<ResumeProjectRequest> request) {
        Integer resumeId = request.get(0).getResumeId();
        //构建简历工作经验信息信息
        List<ResumeProject> projectList = Lists.newArrayList();
        request.forEach(resumeProjectRequest ->  {
            ResumeProject resumeProject = new ResumeProject();
            resumeProject.setResumeId(resumeId);
            BeanUtils.copyProperties(resumeProjectRequest,resumeProject);
            projectList.add(resumeProject);
        });
        resumeProjectMapper.batchInsert(projectList);
        return APIResult.ok();
    }

}
