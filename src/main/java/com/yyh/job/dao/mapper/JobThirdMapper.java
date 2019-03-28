package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobThird;

public interface JobThirdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobThird record);

    int insertSelective(JobThird record);

    JobThird selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobThird record);

    int updateByPrimaryKey(JobThird record);
}