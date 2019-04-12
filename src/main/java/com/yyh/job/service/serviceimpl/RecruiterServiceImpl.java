package com.yyh.job.service.serviceimpl;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.RecruiterMapper;
import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.request.BindCompanyRequest;
import com.yyh.job.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-04-12 22:08
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterMapper recruiterMapper;

    /**
     * 招聘者绑定公司
     *
     * @param request
     * @return
     */
    @Override
    public APIResult bindCompany(BindCompanyRequest request) {
        Recruiter recruiter = new Recruiter();
        recruiter.setUserId(request.getRecruiterId());
        recruiter.setCompanyId(request.getCompanyId());
        recruiter.setPosition(request.getPosition());
        recruiter.setCanUpdate(CommonEnum.ZERO.getCode());
        recruiter.setIsOwner(CommonEnum.ZERO.getCode());
        recruiter.setStatus(CommonEnum.ZERO.getCode());
        recruiterMapper.insert(recruiter);
        return APIResult.ok();
    }
}

