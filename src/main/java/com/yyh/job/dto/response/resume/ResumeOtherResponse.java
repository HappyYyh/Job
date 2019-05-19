package com.yyh.job.dto.response.resume;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.response.resume
 * @author: 昊天
 * @date: 2019-05-18 11:12
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeOtherResponse {

    /**
     * 主键
     */
    private Integer id;

    /**
     * url
     */
    private String url;

    /**
     * 名称
     */
    private String name;

    /**
     * 修改时间
     */
    private String updateTime;
}
