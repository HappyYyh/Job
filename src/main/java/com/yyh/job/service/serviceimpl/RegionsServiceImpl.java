package com.yyh.job.service.serviceimpl;

import com.yyh.job.dao.mapper.CityMapper;
import com.yyh.job.dao.mapper.CountryMapper;
import com.yyh.job.dao.mapper.ProvinceMapper;
import com.yyh.job.dao.model.City;
import com.yyh.job.dao.model.Country;
import com.yyh.job.dao.model.Province;
import com.yyh.job.service.RegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-03-28 20:55
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class RegionsServiceImpl implements RegionsService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CountryMapper countryMapper;

    /**
     * 获取所有的省份
     *
     * @return
     */
    @Override
    public List<Province> getAllProvince() {
        return provinceMapper.getAllProvince();
    }

    /**
     * 根据省份序号获取城市
     *
     * @param provinceId
     * @return
     */
    @Override
    public List<City> getCitysByProvinceId(String provinceId) {
        return cityMapper.getCitysByProvinceId(provinceId);
    }

    /**
     * 获取所有城市
     *
     * @return
     */
    @Override
    public List<City> getAllCitys() {
        return cityMapper.getAllCitys();
    }

    /**
     * 根据城市序号获取县区
     *
     * @param cityId
     * @return
     */
    @Override
    public List<Country> getCountrysByCityId(String cityId) {
        return countryMapper.getCountrysByCityId(cityId);
    }

    /**
     * 获取所有的区县
     *
     * @return
     */
    @Override
    public List<Country> getAllCountrys() {
        return countryMapper.getAllCountrys();
    }
}
