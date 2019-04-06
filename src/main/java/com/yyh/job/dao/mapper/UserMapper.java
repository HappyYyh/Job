package com.yyh.job.dao.mapper;

import com.yyh.job.dao.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据电话和邮箱查找
     * @param phone
     * @param email
     * @return
     */
    User selectByPhoneAndEmail(@Param("phone") String phone, @Param("email") String email);

    /**
     * 根据密码和 （手机或者邮箱）查找
     * @param phoneAndEmail
     * @return
     */
    User selectByPhoneOREmail(String phoneAndEmail);
}