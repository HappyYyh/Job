package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobSend;
import org.apache.ibatis.annotations.Param;

public interface JobSendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobSend record);

    int insertSelective(JobSend record);

    JobSend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobSend record);

    int updateByPrimaryKey(JobSend record);

    /**
     * 根据userId和jobId查询
     * @param userId
     * @param jobId
     * @return
     */
    JobSend selectByJobIdAndUserId(@Param("userId") Integer userId,@Param("jobId") Integer jobId);
}