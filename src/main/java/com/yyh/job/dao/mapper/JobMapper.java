package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Job;
import com.yyh.job.dto.request.job.QueryJobRequest;
import com.yyh.job.dto.response.job.QueryJobResponse;

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

    /**
     * 查询条件查询
     * @param request
     * @return
     */
    List<QueryJobResponse> selectJobList(QueryJobRequest request);

    /**
     * 根据companyId查询
     * @param companyId
     * @return
     */
    List<Job> selectByCompanyId(Integer companyId);
}