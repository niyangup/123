package com.niyang.mapper;

import com.github.pagehelper.Page;
import com.niyang.domain.Version;

/**
 * @author niyangup
 * @since 2020-02-25 20:18
 */
public interface VersionMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Version record);

  int insertSelective(Version record);

  Version selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Version record);

  int updateByPrimaryKey(Version record);

  Page<Version> finAll();

  Version getLastestVersion();

}
