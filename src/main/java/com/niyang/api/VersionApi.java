package com.niyang.api;

import com.github.pagehelper.Page;
import com.niyang.domain.Version;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版本相关api.
 *
 * @author niyangup
 * @since 2020-02-25 20:19
 */
@Api(value = "version相关api", tags = "version相关api")
@RestController
@RequestMapping("/api/version")
public interface VersionApi {

  @ApiOperation(value = "根据id获取版本信息", notes = "根据id获取版本信息")
  @GetMapping(value = "/find-by-id")
  Version findById(@RequestParam Integer id);

  @ApiOperation(value = "分页获取所有版本信息", notes = "分页获取所有版本信息")
  @GetMapping(value = "/find-all")
  Page<Version> findAll();

  @ApiOperation(value = "获取最新版本", notes = "获取最新版本")
  @GetMapping(value = "/get-lastest-version")
  Version getLastestVersion();
}
