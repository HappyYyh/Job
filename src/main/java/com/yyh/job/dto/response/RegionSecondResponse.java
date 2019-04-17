package com.yyh.job.dto.response;

import lombok.Data;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.dto.response
 * @author: 昊天
 * @date: 2019-04-09 17:51
 * @since V1.1.0-SNAPSHOT
 */
@Data
public class RegionSecondResponse {

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市id
     */
    private String cityId;

    private List<RegionThirdResponse> regionThirdResponseList;
}
