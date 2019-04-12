package com.yyh.job.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.request
 * @author: 昊天
 * @date: 2019-04-12 22:06
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class BindCompanyRequest {

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
     * 职位
     */
    @NotBlank
    private String position;


}
