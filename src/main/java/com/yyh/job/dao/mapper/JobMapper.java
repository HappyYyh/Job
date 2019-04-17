package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Job;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKeyWithBLOBs(Job record);

    int updateByPrimaryKey(Job record);

    /**
     * 根据recruiterId查找
     * @param recruiterId
     * @return
     */
    List<Job> selectByRecruiterId(Integer recruiterId);
}