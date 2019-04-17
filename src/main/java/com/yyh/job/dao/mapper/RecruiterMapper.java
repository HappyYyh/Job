package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Recruiter;
import com.yyh.job.dto.response.BindCompanyRecruiterResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruiterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruiter record);

    int insertSelective(Recruiter record);

    Recruiter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruiter record);

    int updateByPrimaryKey(Recruiter record);

    /**
     * 根据recruiterId查询 检验是否存在记录
     * @param recruiterId
     * @return
     */
    Recruiter selectByRecruiterId(Integer recruiterId);

    /**
     * 根据recruiterId和companyId查询信息
     * @param recruiterId
     * @param companyId
     * @return
     */
    Recruiter selectByRecruiterIdAndCompanyId(@Param("recruiterId") Integer recruiterId, @Param("companyId") Integer companyId);

    /**
     * 根据公司id查询招聘者信息
     * @param companyId
     * @return
     */
    List<BindCompanyRecruiterResponse> selectRecruitersByCompanyId(Integer companyId);
}