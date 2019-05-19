package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeOther;

import java.util.List;

public interface ResumeOtherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeOther record);

    int insertSelective(ResumeOther record);

    ResumeOther selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeOther record);

    int updateByPrimaryKey(ResumeOther record);

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    List<ResumeOther> selectByUserId(Integer userId);
}