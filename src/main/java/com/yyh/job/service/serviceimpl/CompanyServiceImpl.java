package com.yyh.job.service.serviceimpl;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.CompanyMapper;
import com.yyh.job.dao.model.Company;
import com.yyh.job.dto.request.CommonCompanyRequest;
import com.yyh.job.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 企业认证(新增)
     *
     * @param request
     * @return
     */
    @Override
    public APIResult certificate(CommonCompanyRequest request) {
        Company company = new Company();
        BeanUtils.copyProperties(request,company);
        company.setIsStop(CommonEnum.ONE.getCode());
        company.setGmtCreate(new Date());
        company.setGmtUpdate(new Date());
        try {
            companyMapper.insertSelective(company);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResult.error(BaseEnum.ADD_COMPANY_ERROR);
        }
        return APIResult.ok();
    }
}
