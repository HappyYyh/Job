package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.CommonCompanyRequest;

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
}