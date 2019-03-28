package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeProject;

public interface ResumeProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeProject record);

    int insertSelective(ResumeProject record);

    ResumeProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeProject record);

    int updateByPrimaryKeyWithBLOBs(ResumeProject record);

    int updateByPrimaryKey(ResumeProject record);
}