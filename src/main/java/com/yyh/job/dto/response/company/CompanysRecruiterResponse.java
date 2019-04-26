package com.yyh.job.dto.response.company;

import lombok.Data;

/**
 * @Package com.yyh.job.dto.response.company
 * @author: 昊天
 * @date: 2019-04-26 21:03
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class CompanysRecruiterResponse {

    /**
     * 头像
     */
    private String headImg;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 职位
     */
    private String position;

}
