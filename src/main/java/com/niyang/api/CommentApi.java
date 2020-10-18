package com.niyang.api;

import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论相关api.
 *
 * @author niyangup
 * @since 2020-02-25 20:38
 */
@Api(value = "comment相关api", tags = "comment相关api")
@RestController
@RequestMapping("/api/comment")
public interface CommentApi {

  @ApiOperation(value = "根据id获取评论信息", notes = "根据id获取评论信息")
  @GetMapping(value = "/find-by-id")
  Comment findById(@RequestParam Integer id);

  @ApiOperation(value = "根据新闻id获取评论信息", notes = "根据新闻id获取评论信息")
  @GetMapping(value = "/find-by-news-id")
  RestControllerResult<List<Comment>> findByNewsId(@RequestParam("newsId") Integer newsId);

  @ApiOperation(value = "插入评论信息", notes = "插入评论信息")
  @PostMapping(value = "/insert-comment")
  Boolean insertComment(@RequestBody Comment comment);
}
