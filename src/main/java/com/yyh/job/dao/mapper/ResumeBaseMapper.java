package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeBase;

public interface ResumeBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeBase record);

    int insertSelective(ResumeBase record);

    ResumeBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeBase record);

    int updateByPrimaryKeyWithBLOBs(ResumeBase record);

    int updateByPrimaryKey(ResumeBase record);
}