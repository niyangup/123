package com.niyang.controller;

import com.github.pagehelper.Page;
import com.niyang.api.CollectionApi;
import com.niyang.base.util.CheckEmptyUtil;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.Collection;
import com.niyang.domain.News;
import com.niyang.service.CollectionService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niyangup
 * @since 2020-02-25 20:50
 */
@RestController
public class CollectionController implements CollectionApi {
  @Resource CollectionService collectionService;

  @Override
  public Collection findById(Integer id) {
    return collectionService.selectByPrimaryKey(id);
  }

  @Override
  public Boolean checkCollected(Integer userId, Integer newsId) {
    return collectionService.checkCollected(userId, newsId);
  }

  @Override
  public Boolean deleteCollected(Integer userId, Integer newsId) {
    return collectionService.deleteCollected(userId, newsId);
  }

  @Override
  public Boolean insertCollected(Integer userId, Integer newsId) {
    return collectionService.insertCollected(userId, newsId);
  }

  @Override
  public RestControllerResult<List<News>> listByUserId(Integer userId) {
    RestControllerResult<List<News>> result = new RestControllerResult<>();
    if (CheckEmptyUtil.isEmpty(userId)) {
      result.setSuccess(false);
      result.setData(null);
      return result;
    }
    List<News> list = collectionService.listByUserId(userId);
    result.setSuccess(true);
    result.setData(list);
    return result;
  }
}
