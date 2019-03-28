package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeExperience;

public interface ResumeExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeExperience record);

    int insertSelective(ResumeExperience record);

    ResumeExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeExperience record);

    int updateByPrimaryKeyWithBLOBs(ResumeExperience record);

    int updateByPrimaryKey(ResumeExperience record);
}