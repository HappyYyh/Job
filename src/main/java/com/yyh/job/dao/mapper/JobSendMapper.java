package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobSend;

public interface JobSendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobSend record);

    int insertSelective(JobSend record);

    JobSend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobSend record);

    int updateByPrimaryKey(JobSend record);
}