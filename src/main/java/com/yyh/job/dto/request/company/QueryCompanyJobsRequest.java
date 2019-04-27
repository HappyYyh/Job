package com.yyh.job.dto.request.company;

import com.yyh.job.common.base.BaseRequest;
import lombok.Data;

/**
 * @Package com.yyh.job.dto.request.company
 * @author: 昊天
 * @date: 2019-04-26 21:35
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class QueryCompanyJobsRequest extends BaseRequest {

    /**
     * 公司id
     */
    private Integer companyId;
}
