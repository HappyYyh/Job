package com.yyh.job.dto.request.job;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.request.job
 * @author: 昊天
 * @date: 2019-04-28 20:50
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class CommonJobSendRequest {

    /**
     * 职位id
     */
    private Integer jobId;

    /**
     * 用户id
     */
    private Integer userId;
}
