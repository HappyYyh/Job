package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeOther;

public interface ResumeOtherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeOther record);

    int insertSelective(ResumeOther record);

    ResumeOther selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeOther record);

    int updateByPrimaryKey(ResumeOther record);
}