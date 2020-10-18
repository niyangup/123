package com.niyang.api;

import com.github.pagehelper.Page;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.News;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 新闻相关api.
 *
 * @author niyangup
 * @since 2020-02-25 20:38
 */
@Api(value = "news相关api", tags = "news相关api")
@RestController
@RequestMapping("/api/news")
public interface NewsApi {

  @ApiOperation(value = "根据id获取新闻信息", notes = "根据id获取新闻信息")
  @GetMapping(value = "/find-by-id")
  News findById(@RequestParam Integer id);

  @ApiOperation(value = "分页获取news", notes = "分页获取news")
  @GetMapping(value = "/find-by-page")
  RestControllerResult<Page<News>> findByPage(
      @RequestParam("pageNum") Integer pageNum,
      @RequestParam("pageSize") Integer pageSize,
      @RequestParam("cateId") Integer cateId);

  @ApiOperation(value = "文件上传", notes = "文件上传")
  @PostMapping(value = "/file-upload-news")
  String fileUploadNews(
      HttpServletRequest request,
      @RequestParam("upload") MultipartFile upload,
      @RequestParam("title") String title,
      @RequestParam("desc") String desc,
      @RequestParam("content") String content,
      @RequestParam("categoryId") String categoryId)
      throws Exception;
}
