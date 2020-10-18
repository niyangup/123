package com.niyang.mapper;

import com.github.pagehelper.Page;
import com.niyang.domain.News;
import org.apache.ibatis.annotations.Param;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
public interface NewsMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(News record);

  int updateByPrimaryKey(News record);

  Page<News> findByPage(
      @Param("cateId") Integer cateId,
      @Param("pageNum") int pageNum,
      @Param("pageSize") int pageSize); // 分类id

  News findById(@Param("id") Integer id);
}
