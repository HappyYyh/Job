package com.yyh.job.dto.request.resume;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


/**
 * @Package com.yyh.job.dto.request.resume
 * @author: 昊天
 * @date: 2019-04-17 20:44
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeEducationRequest {


    /**
     * 学校名称
     */
    private String universityName;

    /**
     * 开始时间(4位 形如 ：2018)
     */
    @Length(min = 4,max = 4,message = "日期不规范")
    private String startYear;

    /**
     * 结束时间
     */
    @Length(min = 4,max = 4,message = "日期不规范")
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
