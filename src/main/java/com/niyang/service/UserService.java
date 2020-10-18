package com.niyang.service;

import com.github.pagehelper.Page;
import com.niyang.domain.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author niyangup
 * @since 2020-02-25 20:28
 */
@Transactional
public interface UserService {

  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  User selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  Page<User> findAll();

  User logIn(String username, String userPwd);

  boolean registerUser(User user);

  boolean updatePwd(int id, String pwd);

  User checkTel(String tel);

  boolean updatePwdByTel(String tel, String pwd);
}
