package com.yyh.job.dto.request;

import lombok.Data;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-06 10:37
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class UserLoginRequest {

    /**
     * 手机或者邮箱
     */
    private String phoneAndEmail;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String checkCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 登陆方式 0密码登陆 1验证码登陆
     */
    private Integer loginType;
}
