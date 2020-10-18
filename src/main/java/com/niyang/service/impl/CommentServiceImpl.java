package com.niyang.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.niyang.mapper.CommentMapper;
import com.niyang.domain.Comment;
import com.niyang.service.CommentService;
/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@Service
public class CommentServiceImpl implements CommentService {

  @Resource private CommentMapper commentMapper;

  @Override
  public int deleteByPrimaryKey(Integer id) {
    return commentMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(Comment record) {
    record.setCommitTime(LocalDateTime.now().toString());
    return commentMapper.insert(record);
  }

  @Override
  public int insertSelective(Comment record) {
    return commentMapper.insertSelective(record);
  }

  @Override
  public Comment selectByPrimaryKey(Integer id) {
    return commentMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(Comment record) {
    return commentMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(Comment record) {
    return commentMapper.updateByPrimaryKey(record);
  }

  @Override
  public List<Comment> findByNewsId(Integer newsId) {
    List<Comment> commentList = commentMapper.findByNewsId(newsId);
    return commentList;
  }
}
