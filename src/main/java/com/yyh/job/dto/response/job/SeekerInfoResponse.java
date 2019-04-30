package com.yyh.job.dto.response.job;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.response.job
 * @author: 昊天
 * @date: 2019-04-30 11:47
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class SeekerInfoResponse {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 简历基础id
     */
    private Integer resumeBaseId;


}
