package com.niyang.service.impl;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.niyang.domain.Category;
import com.niyang.mapper.CategoryMapper;
import com.niyang.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

  @Resource private CategoryMapper categoryMapper;

  @Override
  public int deleteByPrimaryKey(Integer id) {
    return categoryMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(Category record) {
    return categoryMapper.insert(record);
  }

  @Override
  public int insertSelective(Category record) {
    return categoryMapper.insertSelective(record);
  }

  @Override
  public Category selectByPrimaryKey(Integer id) {
    return categoryMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(Category record) {
    return categoryMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(Category record) {
    return categoryMapper.updateByPrimaryKey(record);
  }

  @Override
  public Page<Category> findAll() {
    return categoryMapper.findAll();
  }
}
