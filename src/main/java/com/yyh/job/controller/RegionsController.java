package com.yyh.job.controller;

import com.yyh.job.dao.model.Country;
import com.yyh.job.dao.model.Province;
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

    @GetMapping("/getAllProvince")
    public List<Province> getAllProvince(){
        return regionsService.getAllProvince();
    }

    @GetMapping("/getCountrysByCityId")
    public List<Country> getCountrysByCityId(String cityId){
        return regionsService.getCountrysByCityId(cityId);
    }
}
