package com.yyh.job.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.BaseResponse;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.CompanyMapper;
import com.yyh.job.dao.mapper.RecruiterMapper;
import com.yyh.job.dao.model.Company;
import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.request.company.CommonCompanyRequest;
import com.yyh.job.dto.request.company.QueryCompanyRequest;
import com.yyh.job.dto.request.company.UpdateCompanyRequest;
import com.yyh.job.dto.response.company.QueryCompanyResponse;
import com.yyh.job.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
}
