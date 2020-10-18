package com.niyang.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.niyang.mapper.VideoMapper;
import com.niyang.domain.Video;
import com.niyang.service.VideoService;
/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@Service
public class VideoServiceImpl implements VideoService {

  @Resource private VideoMapper videoMapper;

  @Override
  public int deleteByPrimaryKey(Integer id) {
    return videoMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(Video record) {
    return videoMapper.insert(record);
  }


  @Override
  public Video selectByPrimaryKey(Integer id) {
    return videoMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(Video record) {
    return videoMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(Video record) {
    return videoMapper.updateByPrimaryKey(record);
  }

  @Override
  public Page<Video> findByPage(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);

    return videoMapper.findByPage();
  }
}
