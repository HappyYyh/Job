package com.yyh.job.dto.request.user;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-05 20:01
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class CommonUserRequest {

    /**
     * 手机号
     */
    @Length(min = 11,max = 11)
    private String phone;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 验证码
     */
    @Length(min = 6,max = 6)
    private String checkCode;
    /**
     * 密码
     */
    @Length(min = 6,max = 18)
    private String password;

    /**
     * 角色 0是求职者，1是招聘者
     */
    private Integer role;


}
