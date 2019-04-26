package com.yyh.job.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.BaseResponse;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.JobMapper;
import com.yyh.job.dao.mapper.RecruiterMapper;
import com.yyh.job.dao.model.Job;
import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.request.job.CommonJobRequest;
import com.yyh.job.dto.request.job.QueryJobRequest;
import com.yyh.job.dto.response.job.QueryJobResponse;
import com.yyh.job.service.JobService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-04-14 09:49
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private RecruiterMapper recruiterMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult addJob(CommonJobRequest request) {
        if(null == request.getRecruiterId()){
            return APIResult.error();
        }
        //1、首先查询是否绑定了公司
        Recruiter recruiter = recruiterMapper.selectByRecruiterId(request.getRecruiterId());
        if(null == recruiter){
            return APIResult.error(BaseEnum.NOT_BIND_COMPANY);
        }
        //2、检验是否已经通过审核
        if(CommonEnum.ZERO.getCode().equals(recruiter.getStatus())){
            return APIResult.error(BaseEnum.NOT_COMPLATE_BIND);
        }
        //3、新增
        Job job = new Job();
        BeanUtils.copyProperties(request,job);
        job.setCompanyId(recruiter.getCompanyId());
        job.setCreateId(request.getRecruiterId());
        job.setGmtCreate(new Date());
        jobMapper.insert(job);
        return APIResult.ok();
    }

    /**
     * 查找招聘者发布的职位
     *
     * @param request
     * @return
     */
    @Override
    public APIResult getJobList(QueryJobRequest request) {
        Page page = PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<Job> jobList = jobMapper.selectByRecruiterId(request.getRecruiterId());
        return APIResult.create(BaseResponse.create(page.getTotal(),jobList));
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @Override
    public APIResult detail(Integer id) {
        return APIResult.create(jobMapper.selectByPrimaryKey(id));
    }

    /**
     * 修改
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult update(CommonJobRequest request) {
        Job job = new Job();
        BeanUtils.copyProperties(request,job);
        job.setId(request.getJobId());
        jobMapper.updateByPrimaryKeySelective(job);
        return APIResult.ok();
    }

    /**
     * 查询职位列表
     *
     * @param request
     * @return
     */
    @Override
    public APIResult queryJobList(QueryJobRequest request) {
        Page page = PageHelper.startPage(request.getPageNo(),request.getPageSize());
        List<QueryJobResponse> responseList = jobMapper.selectJobList(request);
        return APIResult.create(BaseResponse.create(page.getTotal(),responseList));
    }
}
