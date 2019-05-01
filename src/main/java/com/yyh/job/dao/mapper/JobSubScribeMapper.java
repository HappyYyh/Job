package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobSubScribe;

import java.util.List;

public interface JobSubScribeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobSubScribe record);

    int insertSelective(JobSubScribe record);

    JobSubScribe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobSubScribe record);

    int updateByPrimaryKey(JobSubScribe record);

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    JobSubScribe selectByUserId(Integer userId);

    /**
     * 查询订阅者的ID
     * @param category
     * @return
     */
    List<Integer> selectByCategory(String category);
}