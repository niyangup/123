package com.niyang.mapper;

import com.niyang.domain.Comment;
import java.util.List;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
public interface CommentMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Comment record);

  int insertSelective(Comment record);

  Comment selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Comment record);

  int updateByPrimaryKey(Comment record);

  List<Comment> findByNewsId(Integer newsId);
}
