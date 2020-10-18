package com.niyang.api;

import com.niyang.domain.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分类相关api.
 *
 * @author niyangup
 * @since 2020-02-25 20:38
 */
@Api(value = "category相关api", tags = "category相关api")
@RestController
@RequestMapping("/api/category")
public interface CategoryApi {

  @ApiOperation(value = "根据id获取分类信息", notes = "根据id获取分类信息")
  @GetMapping(value = "/find-by-id")
  Category findById(@RequestParam Integer id);

  @ApiOperation(value = "分页获取所有分类信息", notes = "分页获取所有分类信息")
  @GetMapping(value = "/find-all")
  List<Category> findAll();
}
