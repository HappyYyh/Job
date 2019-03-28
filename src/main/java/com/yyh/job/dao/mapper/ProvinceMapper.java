package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Province;

import java.util.List;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    /**
     * 获取所有省份
     * @return
     */
    List<Province> getAllProvince();
}