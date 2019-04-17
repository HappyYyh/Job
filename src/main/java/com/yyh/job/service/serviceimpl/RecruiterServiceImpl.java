package com.yyh.job.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.BaseResponse;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.RecruiterMapper;
import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.request.BindCompanyRequest;
import com.yyh.job.dto.request.CommonRecruiterRequest;
import com.yyh.job.dto.request.RecruiterListRequest;
import com.yyh.job.dto.response.BindCompanyRecruiterResponse;
import com.yyh.job.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult bindCompany(BindCompanyRequest request) {
        //先查询是否有绑定记录
        Recruiter isExist = recruiterMapper.selectByRecruiterId(request.getRecruiterId());
        if(isExist != null){
            return APIResult.create(BaseEnum.ALREADY_BIND_COMPANY);
        }
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

    /**
     * 查询招聘者信息
     *
     * @param request
     * @return
     */
    @Override
    public APIResult getRecruiters(RecruiterListRequest request) {
        //分页
        Page page = PageHelper.startPage(request.getPageNo(),request.getPageSize());
        List<BindCompanyRecruiterResponse> responseList = recruiterMapper.selectRecruitersByCompanyId(request.getCompanyId());
        return APIResult.create(BaseResponse.create(page.getTotal(),responseList));
    }

    /**
     * 修改招聘者权限
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult updateRecruiterInfo(CommonRecruiterRequest request) {
        //先查询记录
        Recruiter recruiter = recruiterMapper.selectByRecruiterIdAndCompanyId(request.getRecruiterId(), request.getCompanyId());
        if(CommonEnum.ZERO.getCode().equals(request.getUpdateType())){
            recruiter.setStatus(CommonEnum.ONE.getCode());
        }else {
            recruiter.setCanUpdate(CommonEnum.ONE.getCode());
        }
        recruiterMapper.updateByPrimaryKeySelective(recruiter);
        return APIResult.ok();
    }
}

