package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dao.model.City;
import com.yyh.job.dao.model.Country;
import com.yyh.job.dao.model.Province;
import com.yyh.job.dto.response.RegionFirstResponse;
import com.yyh.job.service.RegionsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-03-28 20:56
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "RegionsController",description = "省市区")
@RequestMapping("/regions")
public class RegionsController {

    @Autowired
    private RegionsService regionsService;

    /**
     * 获取所有的省市区信息
     * @return
     */
    @GetMapping("/getAllRegions")
    public APIResult<List<RegionFirstResponse>> getAllRegions(){
        return regionsService.getAllRegions();
    }

    /**
     * 获取所有省份
     * @return
     */
    @GetMapping("/getAllProvince")
    public APIResult<List<Province>> getAllProvince(){
        return regionsService.getAllProvince();
    }

    /**
     * 根据省序号查询城市
     * @param provinceId
     * @return
     */
    @GetMapping("/getCitysByProvinceId")
    public APIResult<List<City>> getCitysByProvinceId(String provinceId){
        return regionsService.getCitysByProvinceId(provinceId);
    }


    /**
     * 根据城市序号查区
     * @param cityId
     * @return
     */
    @GetMapping("/getCountrysByCityId")
    public APIResult<List<Country>> getCountrysByCityId(String cityId){
        return regionsService.getCountrysByCityId(cityId);
    }
}
