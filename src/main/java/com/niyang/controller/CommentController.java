package com.niyang.controller;

import com.niyang.api.CommentApi;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.Comment;
import com.niyang.service.CommentService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niyangup
 * @since 2020-02-25 20:49
 */
@RestController
public class CommentController implements CommentApi {

  @Resource CommentService commentService;

  @Override
  public Comment findById(Integer id) {
    return commentService.selectByPrimaryKey(id);
  }

  @Override
  public RestControllerResult<List<Comment>> findByNewsId(Integer newsId) {
    RestControllerResult result = new RestControllerResult();
    result.setSuccess(true);
    result.setData(commentService.findByNewsId(newsId));
    return result;
  }

  @Override
  public Boolean insertComment(Comment comment) {
    int insert = commentService.insert(comment);
    return insert != 0;
  }
}
