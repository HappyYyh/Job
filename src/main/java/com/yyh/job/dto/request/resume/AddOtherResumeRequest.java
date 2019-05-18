package com.yyh.job.dto.request.resume;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Package com.yyh.job.dto.request.resume
 * @author: 昊天
 * @date: 2019-05-18 10:49
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class AddOtherResumeRequest {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * url
     */
    @NotBlank
    private String url;

    /**
     * 名称
     */
    @NotBlank
    private String name;
}
