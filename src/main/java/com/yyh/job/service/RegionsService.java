package com.yyh.job.service;


import com.yyh.job.common.base.APIResult;
import com.yyh.job.dao.model.City;
import com.yyh.job.dao.model.Country;
import com.yyh.job.dao.model.Province;
import com.yyh.job.dto.response.RegionFirstResponse;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-03-01 21:56
 * @since V1.1.0-SNAPSHOT
 */
public interface RegionsService {

    /**
     * 获取所有的省市区信息
     * @return
     */
    APIResult<List<RegionFirstResponse>> getAllRegions();

    /**
     * 获取所有的省份
     * @return
     */
    APIResult<List<Province>>  getAllProvince();

    /**
     * 根据省份序号获取城市
     * @param provinceId
     * @return
     */
    APIResult<List<City>> getCitysByProvinceId(String provinceId);

    /**
     * 获取所有城市
     * @return
     */
    List<City> getAllCitys();

    /**
     * 根据城市序号获取县区
     * @param cityId
     * @return
     */
    APIResult<List<Country>> getCountrysByCityId(String cityId);

    /**
     * 获取所有的区县
     * @return
     */
    List<Country> getAllCountrys();
}
