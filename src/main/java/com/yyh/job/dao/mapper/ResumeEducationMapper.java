package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeEducation;

public interface ResumeEducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeEducation record);

    int insertSelective(ResumeEducation record);

    ResumeEducation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeEducation record);

    int updateByPrimaryKey(ResumeEducation record);
}