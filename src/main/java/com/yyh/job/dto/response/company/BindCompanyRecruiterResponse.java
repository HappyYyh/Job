package com.yyh.job.dto.response.company;

import lombok.Data;

/**
 * 绑定公司申请者信息
 * @Package com.yyh.job.dto.response
 * @author: 昊天
 * @date: 2019-04-13 15:10
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class BindCompanyRecruiterResponse {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 绑定岗位
     */
    private String position;

    /**
     * 招聘者id
     */
    private Integer recruiterId;

    /**
     * 能否修改(0否1是)
     */
    private Integer canUpdate;

    /**
     * 是否认证者(0否1是)
     */
    private Integer isOwner;

    /**
     * 招聘者是否通过审核(0否1是)
     */
    private Integer status;
}
