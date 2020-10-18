package com.niyang.mapper;

import com.github.pagehelper.Page;
import com.niyang.domain.Category;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
public interface CategoryMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Category record);

  int insertSelective(Category record);

  Category selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Category record);

  int updateByPrimaryKey(Category record);

  Page<Category> findAll();
}
