package com.niyang.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.niyang.domain.Version;
import com.niyang.mapper.VersionMapper;
import com.niyang.service.VersionService;
/**
 * @author niyangup
 * @since 2020-02-25 20:18
 */
@Service
public class VersionServiceImpl implements VersionService {

  @Resource private VersionMapper versionMapper;

  @Override
  public int deleteByPrimaryKey(Integer id) {
    return versionMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(Version record) {
    return versionMapper.insert(record);
  }

  @Override
  public int insertSelective(Version record) {
    return versionMapper.insertSelective(record);
  }

  @Override
  public Version selectByPrimaryKey(Integer id) {
    return versionMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(Version record) {
    return versionMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(Version record) {
    return versionMapper.updateByPrimaryKey(record);
  }

  @Override
  public Page<Version> findAll() {
    PageHelper.startPage(1, 2);
    return versionMapper.finAll();
  }

  @Override
  public Version getLastestVersion() {
    PageHelper.startPage(1, 1);
    return versionMapper.getLastestVersion();
  }
}
