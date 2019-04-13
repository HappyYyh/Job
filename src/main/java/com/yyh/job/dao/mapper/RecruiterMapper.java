package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.response.BindCompanyRecruiterResponse;

import java.util.List;

public interface RecruiterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruiter record);

    int insertSelective(Recruiter record);

    Recruiter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruiter record);

    int updateByPrimaryKey(Recruiter record);

    /**
     * 根据recruiterId查询
     * @param recruiterId
     * @return
     */
    Recruiter selectByRecruiterId(Integer recruiterId);

    /**
     * 根据公司id查询招聘者信息
     * @param companyId
     * @return
     */
    List<BindCompanyRecruiterResponse> selectRecruitersByCompanyId(Integer companyId);
}