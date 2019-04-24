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
}
