package com.niyang.api;

import com.github.pagehelper.Page;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.News;
import com.niyang.domain.Video;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 视频相关api.
 *
 * @author niyangup
 * @since 2020-02-25 20:35
 */
@Api(value = "video相关api", tags = "video相关api")
@RestController
@RequestMapping("/api/video")
public interface VideoApi {

  @ApiOperation(value = "根据id获取视频信息", notes = "根据id获取视频信息")
  @GetMapping(value = "/find-by-id")
  Video findById(@RequestParam Integer id);

  @ApiOperation(value = "分页获取视频信息", notes = "分页获取视频信息")
  @GetMapping(value = "/find-by-page")
  RestControllerResult<List<Video>> findByPage(
      @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

  @ApiOperation(value = "上传视频", notes = "上传视频")
  @PostMapping(value = "/file-upload-video")
  String fileUploadVideo(
      HttpServletRequest request,
      @RequestParam("upload") MultipartFile upload,
      @RequestParam("title") String title)
      throws Exception;
}
