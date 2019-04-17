package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.City;

import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    /**
     * 根据省份序号获取城市
     * @param provinceId
     * @return
     */
    List<City> getCitysByProvinceId(String provinceId);

    /**
     * 获取所有城市
     * @return
     */
    List<City> getAllCitys();
}