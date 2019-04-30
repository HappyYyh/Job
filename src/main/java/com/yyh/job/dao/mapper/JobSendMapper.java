package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.JobSend;
import com.yyh.job.dto.response.job.RecruiterGotListResponse;
import com.yyh.job.dto.response.job.SeekerSendListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据根据userId和status查询
     * @param userId
     * @param type
     * @return
     */
    List<SeekerSendListResponse> selectByUserIdAndStatus(@Param("userId") Integer userId, @Param("type") Integer type);

    /**
     * 招聘者查询
     * @param recruiterId
     * @return
     */
    List<RecruiterGotListResponse> selectByRecruiterId(Integer recruiterId);
}