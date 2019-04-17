package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeExperience;

import java.util.List;

public interface ResumeExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeExperience record);

    int insertSelective(ResumeExperience record);

    ResumeExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeExperience record);

    int updateByPrimaryKeyWithBLOBs(ResumeExperience record);

    int updateByPrimaryKey(ResumeExperience record);

    /**
     * 批量插入信息
     * @param resumeExperienceList
     * @return
     */
    int batchInsert(List<ResumeExperience> resumeExperienceList);
}