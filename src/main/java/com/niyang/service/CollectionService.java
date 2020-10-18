package com.niyang.service;

import com.github.pagehelper.Page;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.Collection;
import com.niyang.domain.News;
import java.util.List;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
public interface CollectionService {

  int deleteByPrimaryKey(Integer id);

  int insert(Collection record);

  int insertSelective(Collection record);

  Collection selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Collection record);

  int updateByPrimaryKey(Collection record);

  Boolean checkCollected(Integer userId, Integer newsId);

  Boolean deleteCollected(Integer userId, Integer newsId);

  Boolean insertCollected(Integer userId, Integer newsId);

  List<News> listByUserId(Integer userId);
}
