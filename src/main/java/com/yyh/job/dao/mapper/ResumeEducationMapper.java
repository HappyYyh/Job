package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeEducation;

import java.util.List;

public interface ResumeEducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeEducation record);

    int insertSelective(ResumeEducation record);

    ResumeEducation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeEducation record);

    int updateByPrimaryKey(ResumeEducation record);

    /**
     * 批量插入信息
     * @param resumeEducationList
     * @return
     */
    int batchInsert(List<ResumeEducation> resumeEducationList);
}