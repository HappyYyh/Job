package com.yyh.job.dao.model;

import java.util.Date;

/**
 * 职位
 */
public class Job {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 职位分类(3级分类)
     */
    private String category;

    /**
     * 公司id
     */
    private Integer companyId;

    /**
     * 创建者id
     */
    private Integer createId;

    /**
     * 工作地点
     */
    private String workPlace;

    /**
     * 学历(0大专1本科2研究生3博士4不限)
     */
    private Integer workEducation;

    /**
     * 工作经验(0:不限 1:应届毕业生 2:1年以内 3:1~3年 4:3～5年 5:5～10年 6:10年以上)
     */
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
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtUpdate;

    /**
     * 工作职责
     */
    private String jobDuty;

    /**
     * 工作要求
     */
    private String jobRequirement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public Integer getWorkEducation() {
        return workEducation;
    }

    public void setWorkEducation(Integer workEducation) {
        this.workEducation = workEducation;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public Double getSalaryStart() {
        return salaryStart;
    }

    public void setSalaryStart(Double salaryStart) {
        this.salaryStart = salaryStart;
    }

    public Double getSalaryEnd() {
        return salaryEnd;
    }

    public void setSalaryEnd(Double salaryEnd) {
        this.salaryEnd = salaryEnd;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare == null ? null : welfare.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public String getJobDuty() {
        return jobDuty;
    }

    public void setJobDuty(String jobDuty) {
        this.jobDuty = jobDuty == null ? null : jobDuty.trim();
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setJobRequirement(String jobRequirement) {
        this.jobRequirement = jobRequirement == null ? null : jobRequirement.trim();
    }
}