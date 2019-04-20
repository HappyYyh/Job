package com.yyh.job.dto.request.resume;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import java.util.Date;

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
     * date类型生日
     */
    @Past(message = "生日不能早于当前时间")
    private Date birthDayDate;

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
     * 期望职业类型(0:全职 1:兼职 2:实习）
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
     * 当前状态(0:积极找工作 1:随便看看 2:暂时不换工作)
     */
    private Integer expNowStatus;

    /**
     * 到岗时间(0:随时到岗 1:两周以内 2:两周到一个月 3:一到三个月 4:三个月以上)
     */
    private Integer expComeTime;

    /**
     * 个人介绍
     */
    private String introduce;
}
