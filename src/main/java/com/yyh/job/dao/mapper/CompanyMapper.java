package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.Company;
import com.yyh.job.dto.response.CompanyInfoResponse;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);

    /**
     * 根据求职者id获取公司信息
     * @param recruiterId
     * @return
     */
    CompanyInfoResponse selectCompanyByRecruiterId(Integer recruiterId);

    /**
     * 获取所有的公司信息
     * @return
     */
    List<Company> selectAllCompany();
}