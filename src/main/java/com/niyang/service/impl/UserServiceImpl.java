package com.niyang.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.niyang.base.util.CheckEmptyUtil;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.niyang.mapper.UserMapper;
import com.niyang.domain.User;
import com.niyang.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author niyangup
 * @since 2020-02-25 20:28
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

  @Resource private UserMapper userMapper;

  @Override
  public int deleteByPrimaryKey(Integer id) {
    return userMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(User record) {
    return userMapper.insert(record);
  }


  @Override
  public User selectByPrimaryKey(Integer id) {
    return userMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(User record) {
    return userMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(User record) {
    return userMapper.updateByPrimaryKey(record);
  }

  @Override
  public Page<User> findAll() {
    PageHelper.startPage(1, 2);
    return userMapper.findAll();
  }

  @Override
  public User logIn(String username, String userPwd) {
    User user = new User();
    user.setUserName(username);
    user.setUserPwd(userPwd);
    return userMapper.logIn(username, userPwd);
  }

  @Override
  public boolean registerUser(User user) {
    int i = 0;
    try {
      i = userMapper.insert(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i == 1;
  }

  @Override
  public boolean updatePwd(int id, String pwd) {
    return userMapper.updatePwd(id, pwd) == 1;
  }

  @Override
  public User checkTel(String tel) {
    return userMapper.checkTel(tel);
  }

  @Override
  public boolean updatePwdByTel(String tel, String pwd) {
    int i = 0;
    try {
      i = userMapper.updatePwdByTel(tel, pwd);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i == 1;
  }
}
