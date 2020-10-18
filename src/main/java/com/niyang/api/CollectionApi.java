package com.niyang.api;

import com.github.pagehelper.Page;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.Collection;
import com.niyang.domain.News;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收藏相关api.
 *
 * @author niyangup
 * @since 2020-02-25 20:38
 */
@Api(value = "collection相关api", tags = "collection相关api")
@RestController
@RequestMapping("/api/collection")
public interface CollectionApi {

  @ApiOperation(value = "根据id获取收藏信息", notes = "根据id获取收藏信息")
  @GetMapping(value = "/find-by-id")
  Collection findById(@RequestParam Integer id);

  @ApiOperation(value = "根据userId查询收藏newsId信息", notes = "根据userId查询收藏newsId信息")
  @GetMapping(value = "/check-collected")
  Boolean checkCollected(
      @RequestParam("userId") Integer userId, @RequestParam("newsId") Integer newsId);

  @ApiOperation(value = "根据userId和newsId删除收藏信息", notes = "根据userId和newsId删除收藏信息")
  @GetMapping(value = "/delete-collected")
  Boolean deleteCollected(
      @RequestParam("userId") Integer userId, @RequestParam("newsId") Integer newsId);

  @ApiOperation(value = "根据userId和newsId插入收藏信息", notes = "根据userId和newsId删除收藏信息")
  @GetMapping(value = "/insert-collected")
  Boolean insertCollected(
      @RequestParam("userId") Integer userId, @RequestParam("newsId") Integer newsId);

  @ApiOperation(value = "根据userId查询用户收藏信息", notes = "根据userId查询用户收藏信息")
  @GetMapping(value = "/list-by-user-id")
  RestControllerResult<List<News>> listByUserId(@RequestParam("userId") Integer userId);
}
