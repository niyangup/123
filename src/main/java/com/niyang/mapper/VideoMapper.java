package com.niyang.mapper;

import com.github.pagehelper.Page;
import com.niyang.domain.Video;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
public interface VideoMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Video record);

  Video selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Video record);

  int updateByPrimaryKey(Video record);

  Page<Video> findByPage();
}
