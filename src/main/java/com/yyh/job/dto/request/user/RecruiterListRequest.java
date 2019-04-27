package com.yyh.job.dto.request.user;

import com.yyh.job.common.base.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-13 15:23
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class RecruiterListRequest extends BaseRequest {

    /**
     * 公司id
     */
    @NotNull
    private Integer companyId;

}
