package com.yyh.job.dao.model;

import java.util.Date;

/**
 * @author haotian
 */
public class JobSend {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 职位id
     */
    private Integer jobId;

    /**
     * 投递者id
     */
    private Integer userId;

    /**
     * 投递时间
     */
    private Date sendTime;

    /**
     * 状态(0投递成功1被查看2邀请面试3不合适)
     */
    private Integer sendStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
}