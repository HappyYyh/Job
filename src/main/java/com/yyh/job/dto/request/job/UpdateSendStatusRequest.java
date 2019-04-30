package com.yyh.job.dto.request.job;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.request.job
 * @author: 昊天
 * @date: 2019-04-30 16:17
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class UpdateSendStatusRequest {

    /**
     * 职位id
     */
    private Integer jobId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 修改类型
     */
    private Integer type;
}
