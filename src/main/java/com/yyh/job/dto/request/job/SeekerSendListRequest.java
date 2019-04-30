package com.yyh.job.dto.request.job;

import com.yyh.job.common.base.BaseRequest;
import lombok.Data;

/**
 * @Package com.yyh.job.dto.request.job
 * @author: 昊天
 * @date: 2019-04-29 21:40
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class SeekerSendListRequest extends BaseRequest {

    /**
     * 用户的id
     */
    private Integer userId;

    /**
     * 查询类型：0投递成功1被查看2邀请面试3不合适
     */
    private Integer type;
}
