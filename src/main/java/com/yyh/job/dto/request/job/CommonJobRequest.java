package com.yyh.job.dto.request.job;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-14 09:52
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class CommonJobRequest {

    /**
     * 主键
     */
    private Integer jobId;

    /**
     * 职位名称
     */
    @NotBlank(message = "职位名称不能为空")
    private String jobName;

    /**
     * 职位分类(3级分类)
     */
    private String category;

    /**
     * 创建者id
     */
    private Integer recruiterId;

    /**
     * 工作地点
     */
    private String workPlace;

    /**
     * 学历(0大专1本科2研究生3博士4不限)
     */
    @Max(4)
    private Integer workEducation;

    /**
     * 工作经验(0:不限 1:应届毕业生 2:1年以内 3:1~3年 4:3～5年 5:5～10年 6:10年以上)
     */
    @Max(6)
    private Integer workExperience;

    /**
     * 起始薪资
     */
    private Double salaryStart;

    /**
     * 结束薪资
     */
    private Double salaryEnd;

    /**
     * 福利待遇
     */
    private String welfare;

    /**
     * 职位状态(0招聘中1已停止)
     */
    @NotNull
    private Integer status;

    /**
     * 工作职责
     */
    private String jobDuty;

    /**
     * 工作要求
     */
    private String jobRequirement;
}
