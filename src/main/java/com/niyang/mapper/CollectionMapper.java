package com.niyang.mapper;

import com.niyang.domain.Collection;
import com.niyang.domain.News;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
public interface CollectionMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Collection record);

  int insertSelective(Collection record);

  Collection selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Collection record);

  int updateByPrimaryKey(Collection record);

  int checkCollected(@Param("userId") Integer userId, @Param("newsId") Integer newsId);

  Boolean deleteCollected(@Param("userId") Integer userId, @Param("newsId") Integer newsId);

  Boolean insertCollected(@Param("userId") Integer userId, @Param("newsId") Integer newsId);

  List<News> listByUserId(@Param("userId") Integer userId);
}
