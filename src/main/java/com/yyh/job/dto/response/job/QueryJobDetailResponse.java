package com.yyh.job.dto.response.job;

import com.yyh.job.dao.model.Company;
import com.yyh.job.dao.model.Job;
import lombok.Data;


/**
 * @Package com.yyh.job.dto.response.job
 * @author: 昊天
 * @date: 2019-04-27 15:48
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class QueryJobDetailResponse {

    /**
     * 职位基本信息
     */
    private Job job;

    /**
     * 公司信息
     */
    private Company company;

    /**
     * 公司的全部福利待遇
     */
    private String welfares;

    /**
     * 发布时间
     */
    private String createTime;

    /**
     * 招聘者岗位
     */
    private String position;

    /**
     * 招聘者头像
     */
    private String headImg;

    /**
     * 招聘者昵称
     */
    private String nickName;
}
