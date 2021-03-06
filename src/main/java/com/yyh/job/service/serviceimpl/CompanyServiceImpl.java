package com.yyh.job.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.BaseResponse;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.CompanyMapper;
import com.yyh.job.dao.mapper.JobMapper;
import com.yyh.job.dao.mapper.RecruiterMapper;
import com.yyh.job.dao.model.Company;
import com.yyh.job.dao.model.Job;
import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.request.company.CommonCompanyRequest;
import com.yyh.job.dto.request.company.QueryCompanyJobsRequest;
import com.yyh.job.dto.request.company.QueryCompanyRequest;
import com.yyh.job.dto.request.company.UpdateCompanyRequest;
import com.yyh.job.dto.response.company.CompanyDetailResponse;
import com.yyh.job.dto.response.company.QueryCompanyResponse;
import com.yyh.job.service.CompanyService;
import com.yyh.job.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-04-07 22:39
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private RecruiterMapper recruiterMapper;

    @Autowired
    private JobMapper jobMapper;

    /**
     * 企业认证(新增)
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult certificate(CommonCompanyRequest request) {
        Company company = new Company();
        BeanUtils.copyProperties(request,company);
        company.setIsStop(CommonEnum.ONE.getCode());
        company.setGmtCreate(new Date());
        company.setGmtUpdate(new Date());
        try {
            //企业认证
            companyMapper.insertSelective(company);
            //添加认证者信息
            Recruiter recruiter = new Recruiter();
            recruiter.setUserId(request.getRecruiterId());
            recruiter.setCompanyId(company.getId());
            recruiter.setPosition("认证者");
            recruiter.setCanUpdate(CommonEnum.ONE.getCode());
            recruiter.setIsOwner(CommonEnum.ONE.getCode());
            recruiter.setStatus(CommonEnum.ONE.getCode());
            recruiterMapper.insert(recruiter);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.error(BaseEnum.ADD_COMPANY_ERROR);
        }
        return APIResult.ok();
    }

    /**
     * 根据求职者id获取公司信息
     *
     * @param recruiterId
     * @return
     */
    @Override
    public APIResult getCompanyInfo(Integer recruiterId) {
        return APIResult.create(companyMapper.selectCompanyByRecruiterId(recruiterId));
    }

    /**
     * 信息修改
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult updateInfo(UpdateCompanyRequest request) {
        Company company = new Company();
        BeanUtils.copyProperties(request,company);
        companyMapper.updateByPrimaryKeySelective(company);
        return APIResult.ok();
    }

    /**
     * 获取所有的公司名称
     *
     * @return
     */
    @Override
    public APIResult<List<QueryCompanyResponse>> getAllCompanyName() {
        List<Company> companyList = companyMapper.selectAllCompany();
        List<QueryCompanyResponse> responseList = Lists.newArrayList();
        companyList.forEach(company -> {
            QueryCompanyResponse response = new QueryCompanyResponse();
            response.setId(company.getId());
            response.setName(company.getCompanyName());
            responseList.add(response);
        });
        return APIResult.create(responseList);
    }

    /**
     * 根据条件查询公司信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult queryCompanyInfo(QueryCompanyRequest request) {
        Page page = PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<QueryCompanyResponse> responseList = companyMapper.selectCompanyInfos(request);
        List<QueryCompanyResponse> collect = responseList.stream().sorted(Comparator.comparing(QueryCompanyResponse::getJobNum).reversed()).sorted(Comparator.comparing(QueryCompanyResponse::getRecruiterNum).reversed()).collect(Collectors.toList());
        return APIResult.create(BaseResponse.create(page.getTotal(),collect));
    }

    /**
     * 查询公司详情
     *
     * @param id
     * @return
     */
    @Override
    public APIResult getCompanyDetail(Integer id) {
        //查询详情
        CompanyDetailResponse response = companyMapper.selectDetailById(id);
        response.setWelfares(getCompanyWelfares(id));
        return APIResult.create(response);
    }

    /**
     * 获取公司的福利
     *
     * @param companyId
     * @return
     */
    @Override
    public String getCompanyWelfares(Integer companyId) {
        //查询福利标签
        List<String> selectWelfareList = jobMapper.selectWelfareByCompanyId(companyId);
        Set<String> welfareSet = new HashSet<>();
        for (String welfare :selectWelfareList){
            if(StringUtils.isNotBlank(welfare)){
                //分割
                String[] split = welfare.split("/");
                welfareSet.addAll(Arrays.asList(split));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        welfareSet.forEach(x->stringBuilder.append(x).append("/"));
        String welfares = "";
        if(stringBuilder.toString().contains("/")){
            //移除最后一个/
            welfares = stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
        }
        return welfares;
    }


    /**
     * 查询公司下职位
     *
     * @param request
     * @return
     */
    @Override
    public APIResult getCompanyJobList(QueryCompanyJobsRequest request) {
        Page page = PageHelper.startPage(request.getPageNo(),request.getPageSize());
        List<Job> jobList = jobMapper.selectByCompanyId(request.getCompanyId());
        jobList.forEach(job -> {
            if(StringUtils.isNotBlank(job.getWorkPlace())){
                //将 浙江省/杭州市/下城区以/分割,返回城市
                String[] split = job.getWorkPlace().split("/");
                job.setWorkPlace(split[1]);
            }
            LocalDate localDate = DateUtil.dateToLocalDate(job.getGmtUpdate());
            //返回发布时间
            String time = localDate.getMonthValue()+"月"+localDate.getDayOfMonth()+"日";
            //这里说明一点，为了减少新建一个bean，后端返回时间，把时间字段填写在jobDuty字段上面
            job.setJobDuty(time);
        });
        return APIResult.create(BaseResponse.create(page.getTotal(),jobList));
    }
}
