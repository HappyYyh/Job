package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobSecond;

public interface JobSecondMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobSecond record);

    int insertSelective(JobSecond record);

    JobSecond selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobSecond record);

    int updateByPrimaryKey(JobSecond record);
}