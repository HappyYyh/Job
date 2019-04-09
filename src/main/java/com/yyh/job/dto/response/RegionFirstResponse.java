package com.yyh.job.dto.response;

import lombok.Data;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.response
 * @author: 昊天
 * @date: 2019-04-09 17:49
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class RegionFirstResponse {

    /**
     * 省名称
     */
    private String name;

    /**
     * 省id
     */
    private String id;

    private List<RegionSecondResponse> children;
}
