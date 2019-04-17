package com.yyh.job.dao.model;

/**
 * 简历教育信息
 * @author haotian
 */
public class ResumeEducation {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 简历id
     */
    private Integer resumeId;

    /**
     * 学校名称
     */
    private String universityName;

    /**
     * 开始时间
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName == null ? null : universityName.trim();
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear == null ? null : startYear.trim();
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear == null ? null : endYear.trim();
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName == null ? null : professionalName.trim();
    }
}