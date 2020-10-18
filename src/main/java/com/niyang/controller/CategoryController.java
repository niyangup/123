package com.niyang.controller;

import com.github.pagehelper.Page;
import com.niyang.api.CategoryApi;
import com.niyang.domain.Category;
import com.niyang.service.CategoryService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niyangup
 * @since 2020-02-25 20:51
 */
@RestController
public class CategoryController implements CategoryApi {
  @Resource CategoryService categoryService;

  @Override
  public Category findById(Integer id) {
    return categoryService.selectByPrimaryKey(id);
  }

  @Override
  public List<Category> findAll() {
    return categoryService.findAll().getResult();
  }
}
