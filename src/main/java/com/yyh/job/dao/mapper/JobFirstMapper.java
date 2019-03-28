package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobFirst;
import com.yyh.job.dto.response.JobFirstCategoryResponse;

import java.util.List;

public interface JobFirstMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobFirst record);

    int insertSelective(JobFirst record);

    JobFirst selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobFirst record);

    int updateByPrimaryKey(JobFirst record);

    /**
     * 获取所有的职位分类
     * @return
     */
    List<JobFirstCategoryResponse> selectAllCategory();
}