package com.yyh.job.dto.request.resume;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-21 16:57
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class ResumeDeleteRequest {

    /**
     * 主键
     */
    @NotNull
    private Integer id;

    /**
     * 删除类型 （0:教育 1:工作 2:项目）
     */
    @NotNull
    private Integer type;
}
