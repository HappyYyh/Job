package com.yyh.job.dto.response;

import com.yyh.job.dao.model.User;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.response
 * @author: 昊天
 * @date: 2019-04-06 16:25
 * @since V1.1.0-SNAPSHOT
 */
public class UserLoginResponse extends User {

    /**
     * 登陆后生成的token
     */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
