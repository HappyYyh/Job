package com.yyh.job.dto.request.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-13 19:47
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class CommonRecruiterRequest {

    /**
     * 招聘者id
     */
    @NotNull
    private Integer recruiterId;

    /**
     * 公司id
     */
    @NotNull
    private Integer companyId;

    /**
     * 修改类型 (0:绑定通过 1:修改公司信息权限 2:绑定拒绝)
     */
    private Integer updateType;
}
