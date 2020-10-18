package com.niyang.service.impl;

import com.github.pagehelper.Page;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.News;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.niyang.mapper.CollectionMapper;
import com.niyang.domain.Collection;
import com.niyang.service.CollectionService;
/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@Service
public class CollectionServiceImpl implements CollectionService {

  @Resource private CollectionMapper collectionMapper;

  @Override
  public int deleteByPrimaryKey(Integer id) {
    return collectionMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(Collection record) {
    return collectionMapper.insert(record);
  }

  @Override
  public int insertSelective(Collection record) {
    return collectionMapper.insertSelective(record);
  }

  @Override
  public Collection selectByPrimaryKey(Integer id) {
    return collectionMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(Collection record) {
    return collectionMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(Collection record) {
    return collectionMapper.updateByPrimaryKey(record);
  }

  @Override
  public Boolean checkCollected(Integer userId, Integer newsId) {
    int count = collectionMapper.checkCollected(userId, newsId);
    return count != 0;
  }

  @Override
  public Boolean deleteCollected(Integer userId, Integer newsId) {
    return collectionMapper.deleteCollected(userId, newsId);
  }

  @Override
  public Boolean insertCollected(Integer userId, Integer newsId) {
    return collectionMapper.insertCollected(userId, newsId);
  }

  @Override
  public List<News> listByUserId(Integer userId) {
    return collectionMapper.listByUserId(userId);
  }
}
