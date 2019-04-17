package com.yyh.job.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-13 21:47
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class UpdateUserRequest {

    /**
     * 用户id
     */
    @NotNull(message = "用户编号不能为空")
    private Integer id;

    /**
     * 头像
     */
    @NotBlank
    private String img;

    /**
     * 昵称
     */
    @NotBlank
    private String nickName;
}
