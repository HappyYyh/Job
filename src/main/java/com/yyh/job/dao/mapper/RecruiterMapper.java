package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Recruiter;

public interface RecruiterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruiter record);

    int insertSelective(Recruiter record);

    Recruiter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruiter record);

    int updateByPrimaryKey(Recruiter record);
}