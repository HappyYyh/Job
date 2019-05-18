package com.yyh.job.dto.response.resume;

import lombok.Data;


/**
 * @Package com.yyh.job.dto.response.resume
 * @author: 昊天
 * @date: 2019-04-20 13:58
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeBaseResponse {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 姓名
     */
    private String name;


    /**
     * 生日
     */
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
    private String phone;

    /**
     * 联系邮箱
     */
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
    private Integer expStartSalary;

    /**
     * 期望结束薪资
     */
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

    /**
     * 是否公开简历：0不公开 1公开
     */
    private Integer isPublic;

    /**
     * 屏蔽的公司id,以逗号分隔
     */
    private String shieldCompanyId;

    /**
     * 屏蔽的公司的数量
     */
    private Integer shieldCompanyCount;
}
