package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumePrivacy;

public interface ResumePrivacyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumePrivacy record);

    int insertSelective(ResumePrivacy record);

    ResumePrivacy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumePrivacy record);

    int updateByPrimaryKey(ResumePrivacy record);
}