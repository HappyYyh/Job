package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.company.CommonCompanyRequest;
import com.yyh.job.dto.request.company.QueryCompanyRequest;
import com.yyh.job.dto.request.company.UpdateCompanyRequest;
import com.yyh.job.dto.response.company.QueryCompanyResponse;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-04-07 22:34
 * @since V1.1.0-SNAPSHOT
 */
public interface CompanyService {

    /**
     * 企业认证(新增)
     * @param request
     * @return
     */
    APIResult certificate(CommonCompanyRequest request);

    /**
     * 根据求职者id获取公司信息
     * @param recruiterId
     * @return
     */
    APIResult getCompanyInfo(Integer recruiterId);

    /**
     * 信息修改
     * @param request
     * @return
     */
    APIResult updateInfo(UpdateCompanyRequest request);

    /**
     * 获取所有的公司名称
     * @return
     */
    APIResult<List<QueryCompanyResponse>> getAllCompanyName();

    /**
     * 根据条件查询公司信息
     * @param request
     * @return
     */
    APIResult queryCompanyInfo(QueryCompanyRequest request);
}
