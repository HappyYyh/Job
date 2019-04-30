package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeBase;
import com.yyh.job.dto.response.resume.MyResumeResponse;
import com.yyh.job.dto.response.resume.ResumeBaseResponse;

public interface ResumeBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeBase record);

    int insertSelective(ResumeBase record);

    ResumeBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeBase record);

    int updateByPrimaryKeyWithBLOBs(ResumeBase record);

    int updateByPrimaryKey(ResumeBase record);

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    ResumeBaseResponse selectByUserId(Integer userId);

    /**
     * 关联查询我的简历
     * @param userId
     * @return
     */
    //MyResumeResponse selectMyResumeByUserId(Integer userId);
}