package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.company.BindCompanyRequest;
import com.yyh.job.dto.request.user.CommonRecruiterRequest;
import com.yyh.job.dto.request.user.RecruiterListRequest;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-04-12 22:03
 * @since V1.1.0-SNAPSHOT
 */
public interface RecruiterService {

    /**
     * 招聘者绑定公司
     * @param request
     * @return
     */
    APIResult bindCompany(BindCompanyRequest request);

    /**
     * 查询招聘者信息
     * @param request
     * @return
     */
    APIResult getRecruiters(RecruiterListRequest request);

    /**
     * 修改招聘者权限
     * @param request
     * @return
     */
    APIResult updateRecruiterInfo(CommonRecruiterRequest request);
}
