package com.yyh.job.dao.model;

/**
 * 简历基础信息
 */
public class ResumeBase {

    /**
     * 主键
     */
    private Integer id;

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
    private String birthDay;

    /**
     * 性别(0男1女)
     */
    private Integer sex;

    /**
     * 所在城市
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
     * 期望职业类型(0全职1兼职2实习）
     */
    private Integer expJobType;

    /**
     * 期望城市
     */
    private String expCity;

    /**
     * 期望起始薪资
     */
    private Integer expStartSalary;

    /**
     * 期望结束薪资
     */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay == null ? null : birthDay.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getExpJob() {
        return expJob;
    }

    public void setExpJob(String expJob) {
        this.expJob = expJob == null ? null : expJob.trim();
    }

    public Integer getExpJobType() {
        return expJobType;
    }

    public void setExpJobType(Integer expJobType) {
        this.expJobType = expJobType;
    }

    public String getExpCity() {
        return expCity;
    }

    public void setExpCity(String expCity) {
        this.expCity = expCity == null ? null : expCity.trim();
    }

    public Integer getExpStartSalary() {
        return expStartSalary;
    }

    public void setExpStartSalary(Integer expStartSalary) {
        this.expStartSalary = expStartSalary;
    }

    public Integer getExpEndSalary() {
        return expEndSalary;
    }

    public void setExpEndSalary(Integer expEndSalary) {
        this.expEndSalary = expEndSalary;
    }

    public Integer getExpNowStatus() {
        return expNowStatus;
    }

    public void setExpNowStatus(Integer expNowStatus) {
        this.expNowStatus = expNowStatus;
    }

    public Integer getExpComeTime() {
        return expComeTime;
    }

    public void setExpComeTime(Integer expComeTime) {
        this.expComeTime = expComeTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}