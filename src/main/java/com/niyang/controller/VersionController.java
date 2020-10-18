package com.niyang.controller;

import com.github.pagehelper.Page;
import com.niyang.api.VersionApi;
import com.niyang.domain.Version;
import com.niyang.service.VersionService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niyangup
 * @since 2020-02-25 20:21
 */
@RestController
public class VersionController implements VersionApi {

  @Resource VersionService versionService;

  @Override
  public Version findById(Integer id) {
    return versionService.selectByPrimaryKey(id);
  }

  @Override
  public Page<Version> findAll() {
    return versionService.findAll();
  }

  @Override
  public Version getLastestVersion() {
    return versionService.getLastestVersion();
  }
}
