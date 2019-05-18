package com.yyh.job.dao.model;

public class ResumePrivacy {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 简历id
     */
    private Integer resumeId;

    /**
     * 是否公开简历 0不公开 1公开
     */
    private Integer isPublic;

    /**
     * 屏蔽公司的id
     */
    private String shieldCompanyId;

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

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public String getShieldCompanyId() {
        return shieldCompanyId;
    }

    public void setShieldCompanyId(String shieldCompanyId) {
        this.shieldCompanyId = shieldCompanyId == null ? null : shieldCompanyId.trim();
    }
}