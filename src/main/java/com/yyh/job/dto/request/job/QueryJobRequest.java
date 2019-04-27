package com.yyh.job.dto.request.job;

import com.yyh.job.common.base.BaseRequest;
import lombok.Data;

/**
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-14 19:05
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class QueryJobRequest extends BaseRequest {

    /**
     * 招聘者id
     */
    private Integer recruiterId;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 行业分类
     */
    private String category;

    /**
     * 城市
     */
    private String city;

    /**
     * 区/县
     */
    private String country;

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
     * 标签:行业分类
     * (0:民营企业 1:电子商务 2:游戏 3:媒体 4:广告营销 5:数据服务 6:医疗健康 7: 生活服务 8:O2O 9:旅游 10:分类信息
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
}
