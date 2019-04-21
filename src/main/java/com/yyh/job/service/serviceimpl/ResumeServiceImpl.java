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
import com.yyh.job.dto.response.resume.*;
import com.yyh.job.service.ResumeService;
import com.yyh.job.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult addBase(ResumeBaseRequest request) {
        ResumeBase resumeBase = copyBase(request);
        int insertBase = resumeBaseMapper.insert(resumeBase);
        if(CommonEnum.ONE.getCode().equals(insertBase)) {
            return APIResult.create(resumeBase);
        }
        return APIResult.error(BaseEnum.ADD_RESUME_BASE_ERROR);
    }

    /**
     * 修改基础简历信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult editBase(ResumeBaseRequest request) {
        if(null == request.getId()){
            return APIResult.error();
        }
        resumeBaseMapper.updateByPrimaryKeySelective(copyBase(request));
        return APIResult.ok();
    }

    private ResumeBase copyBase(ResumeBaseRequest request){
        ResumeBase resumeBase = new ResumeBase();
        BeanUtils.copyProperties(request,resumeBase);
        return resumeBase;
    }

    /**
     * 新增简历教育信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult submitEducation(ResumeEducationRequest request) {
        ResumeEducation resumeEducation = new ResumeEducation();
        BeanUtils.copyProperties(request,resumeEducation);
        if(null == request.getId()){
            //新增
            resumeEducationMapper.insert(resumeEducation);
        }else {
            //修改
            resumeEducationMapper.updateByPrimaryKeySelective(resumeEducation);
        }
        return APIResult.ok();
    }

    /**
     * 新增简历工作经验
     *
     * @param request
     * @return
     */
    @Override
    public APIResult submitExperience(ResumeExperienceRequest request) {
        ResumeExperience resumeExperience = new ResumeExperience();
        BeanUtils.copyProperties(request,resumeExperience);
        if(null == request.getId()) {
            resumeExperienceMapper.insert(resumeExperience);
        }else {
            resumeExperienceMapper.updateByPrimaryKeySelective(resumeExperience);
        }
        return APIResult.ok();
    }

    /**
     * 新增简历项目信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult submitProject(ResumeProjectRequest request) {
        ResumeProject resumeProject = new ResumeProject();
        BeanUtils.copyProperties(request,resumeProject);
        if(null == request.getId()) {
            resumeProjectMapper.insert(resumeProject);
        }else {
            resumeProjectMapper.updateByPrimaryKeySelective(resumeProject);
        }
        return APIResult.ok();
    }

    /**
     * 查看我的简历
     *
     * @param userId
     * @return
     */
    @Override
    public APIResult getResume(Integer userId) {
        MyResumeResponse response = new MyResumeResponse();
        //查询基础信息
        ResumeBaseResponse resumeBaseResponse = resumeBaseMapper.selectByUserId(userId);
        Integer resumeId = resumeBaseResponse.getId();
        //查询教育信息
        List<ResumeEducationResponse> resumeEducationResponseList = resumeEducationMapper.selectByResumeId(resumeId);
        //查询工作信息
        List<ResumeExperienceResponse> resumeExperienceResponseList = resumeExperienceMapper.selectByResumeId(resumeId);
        //查询项目信息
        List<ResumeProjectResponse> resumeProjectResponseList = resumeProjectMapper.selectByResumeId(resumeId);
        //数据填充
        response.setResumeBaseResponse(resumeBaseResponse);
        response.setResumeEducationResponseList(resumeEducationResponseList);
        response.setResumeExperienceResponseList(resumeExperienceResponseList);
        response.setResumeProjectResponseList(resumeProjectResponseList);
        return APIResult.create(response);
    }

}
