package com.yyh.job.dto.response.resume;

import lombok.Data;



/**
 * @Package com.yyh.job.dto.response.resume
 * @author: 昊天
 * @date: 2019-04-17 20:44
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeEducationResponse {

    private Integer id;

    /**
     * 简历基础的id
     */
    private Integer resumeId;


    /**
     * 学校名称
     */
    private String universityName;

    /**
     * 开始时间(4位 形如 ：2018)
     */
    private String startYear;

    /**
     * 结束时间
     */
    private String endYear;

    /**
     * 学历(0大专1本科2研究生3博士)
     */
    private Integer education;

    /**
     * 专业名称
     */
    private String professionalName;
}
