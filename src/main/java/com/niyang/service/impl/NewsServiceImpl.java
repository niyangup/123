package com.niyang.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.niyang.mapper.NewsMapper;
import com.niyang.domain.News;
import com.niyang.service.NewsService;
/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@Service
public class NewsServiceImpl implements NewsService {

  @Resource private NewsMapper newsMapper;

  @Override
  public int deleteByPrimaryKey(Integer id) {
    return newsMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(News record) {
    return newsMapper.insert(record);
  }

  @Override
  public int updateByPrimaryKey(News record) {
    return newsMapper.updateByPrimaryKey(record);
  }

  @Override
  public Page<News> findByPage(Integer cateId, Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    return newsMapper.findByPage(cateId, pageNum, pageSize);
  }

  @Override
  public News findById(Integer id) {
    return newsMapper.findById(id);
  }
}
