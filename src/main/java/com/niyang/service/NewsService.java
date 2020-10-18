package com.niyang.service;

import com.github.pagehelper.Page;
import com.niyang.domain.News;
/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
public interface NewsService {

  int deleteByPrimaryKey(Integer id);

  int insert(News record);

  int updateByPrimaryKey(News record);

  Page<News> findByPage(Integer cateId, Integer pageNum, Integer pageSize);

  News findById(Integer id);
}
