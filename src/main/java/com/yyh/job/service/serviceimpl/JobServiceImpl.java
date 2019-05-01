package com.yyh.job.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.BaseResponse;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.common.enums.RoleEnum;
import com.yyh.job.dao.mapper.CompanyMapper;
import com.yyh.job.dao.mapper.JobMapper;
import com.yyh.job.dao.mapper.RecruiterMapper;
import com.yyh.job.dao.model.Job;
import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.request.job.CommonJobRequest;
import com.yyh.job.dto.request.job.QueryJobRequest;
import com.yyh.job.dto.response.job.QueryJobDetailResponse;
import com.yyh.job.dto.response.job.QueryJobResponse;
import com.yyh.job.service.CompanyService;
import com.yyh.job.service.JobService;
import com.yyh.job.util.DateUtil;
import com.yyh.job.util.SendMsgUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private SendMsgUtil sendMsgUtil;

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
        job.setGmtUpdate(new Date());
        jobMapper.insert(job);

        //4、新增消息到消息队列中
        Map<String,Object> map = new HashMap<>();
        map.put("jobName",job.getJobName());
        map.put("category",job.getCategory());
        map.put("salaryStart",job.getSalaryStart());
        map.put("salaryEnd",job.getSalaryEnd());
        map.put("companyName",companyMapper.selectByPrimaryKey(job.getCompanyId()).getCompanyName());
        map.put("position",recruiter.getPosition());
        map.put("time",DateUtil.getStringDateTime());
        sendMsgUtil.sendMsgToRabbit(RoleEnum.SEEKER,map);

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
        responseList.forEach(queryJobResponse -> {
            if(StringUtils.isNotBlank(queryJobResponse.getWorkPlace())){
                //将 浙江省/杭州市/下城区以/分割
                String[] places = queryJobResponse.getWorkPlace().split("/");
                queryJobResponse.setCity(places[1]);
            }
            LocalDate localDate = DateUtil.dateToLocalDate(queryJobResponse.getGmtUpdate());
            //返回发布时间
            String time = localDate.getMonthValue()+"月"+localDate.getDayOfMonth()+"日";
            queryJobResponse.setCreateTime(time);
        });
        return APIResult.create(BaseResponse.create(page.getTotal(),responseList));
    }

    /**
     * 查询职位详情
     *
     * @param id
     * @return
     */
    @Override
    public APIResult getJobDetail(Integer id) {
        QueryJobDetailResponse response = jobMapper.selectDetailById(id);
        if(response != null) {
            if(response.getJob().getGmtUpdate() !=null) {
                //返回发布时间
                LocalDate localDate = DateUtil.dateToLocalDate(response.getJob().getGmtUpdate());
                String time = localDate.getMonthValue() + "月" + localDate.getDayOfMonth() + "日";
                response.setCreateTime(time);
            }
            if(response.getCompany().getId() != null) {
                response.setWelfares(companyService.getCompanyWelfares(response.getCompany().getId()));
            }
        }
        return APIResult.create(response);
    }
}
