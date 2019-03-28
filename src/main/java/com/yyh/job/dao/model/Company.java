package com.yyh.job.dao.model;

import java.util.Date;

/**
 * 公司信息
 */
public class Company {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 图片
     */
    private String img;

    /**
     * 所在地
     */
    private String belongPlace;

    /**
     * 注册资金
     */
    private String registeredCapital;

    /**
     * 标签:行业分类
     * (1:电子商务 2:游戏 3:媒体 4:广告营销 5:数据服务 6:医疗健康 7: 生活服务 8:O2O 9:旅游 10:分类信息
     *  11:音乐/视频/阅读 12:在线教育 13:社交网络 14:人力资源服务 15:企业服务 16:信息安全 17:智能硬件
     *  18:移动互联网 19:互联网 20:计算机软件 21:通信/网络设备 22:广告/公关/会展 23:互联网金融
     *  24:物流/仓储 25:贸易/进出口 26:咨询 27:工程施工 28:汽车生产 29:其他行业 )
     */
    private Integer industryCategory;

    /**
     * 标签:融资状态（0:未融资 1:天使轮 2:A轮 3:B轮 4:C轮 5:D轮及以上 6:上市公司 7:不需要融资）
     */
    private Integer financingStatus;

    /**
     * 标签:公司规模 (0:少于15人 1:15-50人 2:50-150人 3:150-500人 4:500-2000人 5:2000人以上)
     */
    private Integer staffNum;

    /**
     * 是否停止招聘 （0:停止 1:没有）
     */
    private Integer isStop;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtUpdate;

    /**
     * 介绍
     */
    private String introduce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getBelongPlace() {
        return belongPlace;
    }

    public void setBelongPlace(String belongPlace) {
        this.belongPlace = belongPlace == null ? null : belongPlace.trim();
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    public Integer getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(Integer industryCategory) {
        this.industryCategory = industryCategory;
    }

    public Integer getFinancingStatus() {
        return financingStatus;
    }

    public void setFinancingStatus(Integer financingStatus) {
        this.financingStatus = financingStatus;
    }

    public Integer getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(Integer staffNum) {
        this.staffNum = staffNum;
    }

    public Integer getIsStop() {
        return isStop;
    }

    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}