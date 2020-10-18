package com.niyang.api;

import com.github.pagehelper.Page;
import com.niyang.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关api.
 *
 * @author niyangup
 * @since 2020-02-22 14:49
 */
@Api(value = "user相关api", tags = "user相关api")
@RestController
@RequestMapping("/api/user")
public interface UserApi {

  @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息")
  @GetMapping(value = "/find-by-id")
  User findById(@RequestParam("userId") Integer userId);

  @ApiOperation(value = "分页获取所有user", notes = "分页获取所有user")
  @GetMapping(value = "/find-all")
  Page<User> findAll();

  @ApiOperation(value = "用户登录api", notes = "登录api")
  @GetMapping(value = "/log-in")
  User logIn(@RequestParam("username") String username, @RequestParam("userPwd") String userPwd);

  @ApiOperation(value = "用户注册api", notes = "登录api")
  @PostMapping(value = "/register-user")
  boolean registerUser(@RequestBody User user);

  @ApiOperation(value = "修改密码api", notes = "修改密码api")
  @GetMapping(value = "/update-pwd")
  boolean updatePwd(@RequestParam("id") int id, @RequestParam("pwd") String pwd);

  @ApiOperation(value = "检查手机号api", notes = "检查手机号api")
  @GetMapping(value = "/check-tel")
  User checkTel(@RequestParam("tel") String tel);

  @ApiOperation(value = "手机号修改密码api", notes = "手机号修改密码api")
  @GetMapping(value = "/update-pwd-by-tel")
  boolean updatePwdByTel(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd);
}
