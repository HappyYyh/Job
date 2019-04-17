package com.yyh.job.dto.request.resume;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

/**
 * @Package com.yyh.job.dto.request.resume
 * @author: 昊天
 * @date: 2019-04-17 20:33
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeBaseRequest {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    @Length(max = 10)
    private String birthDay;

    /**
     * 性别(0男1女)
     */
    private Integer sex;

    /**
     * 所在城市 (只限城市名）
     */
    private String city;

    /**
     * 联系手机
     */
    @Length(min = 11,max = 11,message = "手机号码长度为11位")
    private String phone;

    /**
     * 联系邮箱
     */
    @Email
    private String email;

    /**
     * 期望职业
     */
    private String expJob;

    /**
     * 期望职业类型(0全职1兼职2实习）
     */
    private Integer expJobType;

    /**
     * 期望城市 （城市）
     */
    private String expCity;

    /**
     * 期望起始薪资 0～999K
     */
    @Max(999)
    private Integer expStartSalary;

    /**
     * 期望结束薪资
     */
    @Max(999)
    private Integer expEndSalary;

    /**
     * 当前状态(0积极找工作1随便看看2暂时不换工作)
     */
    private Integer expNowStatus;

    /**
     * 到岗时间(0随时1两周以内2两周到一个月3一到三个月4三个月以上)
     */
    private Integer expComeTime;

    /**
     * 个人介绍
     */
    private String introduce;
}
