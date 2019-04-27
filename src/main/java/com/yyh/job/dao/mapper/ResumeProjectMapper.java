package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.ResumeProject;
import com.yyh.job.dto.response.resume.ResumeProjectResponse;

import java.util.List;

public interface ResumeProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeProject record);

    int insertSelective(ResumeProject record);

    ResumeProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeProject record);

    int updateByPrimaryKeyWithBLOBs(ResumeProject record);

    int updateByPrimaryKey(ResumeProject record);

    /**
     * 批量插入信息
     * @param resumeProjectList
     * @return
     */
    int batchInsert(List<ResumeProject> resumeProjectList);

    /**
     * 根据resumeId查询
     * @param resumeId
     * @return
     */
    List<ResumeProjectResponse> selectByResumeId(Integer resumeId);
}