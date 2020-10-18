package com.niyang.mapper;

import com.github.pagehelper.Page;
import com.niyang.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author niyangup
 * @since 2020-02-25 20:28
 */
public interface UserMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  User selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  Page<User> findAll();

  User logIn(@Param("userName") String username, @Param("userPwd") String userPwd);

  int updatePwd(@Param("id") int id, @Param("userPwd") String userPwd);

  User checkTel(@Param("tel") String tel);

  int updatePwdByTel(@Param("tel") String tel, @Param("pwd") String pwd);
}
