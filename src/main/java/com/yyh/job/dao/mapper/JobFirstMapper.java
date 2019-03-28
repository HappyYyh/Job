package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobFirst;

public interface JobFirstMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobFirst record);

    int insertSelective(JobFirst record);

    JobFirst selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobFirst record);

    int updateByPrimaryKey(JobFirst record);
}