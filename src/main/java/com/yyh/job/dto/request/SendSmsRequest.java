package com.yyh.job.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-05 16:17
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class SendSmsRequest {

    /**
     * 电话
     */
    @Length(min = 11,max = 11)
    private String phone;

    /**
     * 验证码类型：0注册验证码 1登陆验证码 2找回密码验证码
     */
    private Integer type;
}
