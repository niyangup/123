package com.niyang.controller;

import com.github.pagehelper.Page;
import com.niyang.api.UserApi;
import com.niyang.domain.User;
import com.niyang.service.UserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niyangup
 * @since 2020-02-21 21:19
 */
@RestController
public class UserController implements UserApi {
  @Resource UserService userService;

  @Override
  public User findById(Integer id) {
    return userService.selectByPrimaryKey(id);
  }

  @Override
  public Page<User> findAll() {
    return userService.findAll();
  }

  @Override
  public User logIn(String username, String userPwd) {
    return userService.logIn(username, userPwd);
  }

  @Override
  public boolean registerUser(User user) {
    return userService.registerUser(user);
  }

  @Override
  public boolean updatePwd(int id, String pwd) {
    return userService.updatePwd(id, pwd);
  }

  @Override
  public User checkTel(String tel) {
    return userService.checkTel(tel);
  }

  @Override
  public boolean updatePwdByTel(String tel, String pwd) {
    return userService.updatePwdByTel(tel,pwd);
  }
}
