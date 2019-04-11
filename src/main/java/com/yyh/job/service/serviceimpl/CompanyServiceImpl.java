package com.yyh.job.service.serviceimpl;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.CompanyMapper;
import com.yyh.job.dao.mapper.RecruiterMapper;
import com.yyh.job.dao.model.Company;
import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.request.CommonCompanyRequest;
import com.yyh.job.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
}
