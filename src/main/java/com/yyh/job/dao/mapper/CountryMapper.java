package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Country;

import java.util.List;

public interface CountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);

    /**
     * 根据城市序号获取县区
     * @param cityId
     * @return
     */
    List<Country> getCountrysByCityId(String cityId);

    /**
     * 获取所有的区县
     * @return
     */
    List<Country> getAllCountrys();
}