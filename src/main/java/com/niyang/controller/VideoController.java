package com.niyang.controller;

import com.github.pagehelper.Page;
import com.niyang.api.VideoApi;
import com.niyang.base.util.CheckEmptyUtil;
import com.niyang.base.util.RestControllerResult;
import com.niyang.domain.Video;
import com.niyang.service.VideoService;
import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author niyangup
 * @since 2020-02-25 20:46
 */
@RestController
public class VideoController implements VideoApi {
  @Resource VideoService videoService;

  @Override
  public Video findById(Integer id) {
    return videoService.selectByPrimaryKey(id);
  }

  @Override
  public RestControllerResult<List<Video>> findByPage(int pageNum, int pageSize) {

    RestControllerResult<List<Video>> result = new RestControllerResult<>();

    if (CheckEmptyUtil.isOrEmpty(pageNum, pageSize)) {
      return result;
    }
    Page<Video> list = videoService.findByPage(pageNum, pageSize);
    result.setSuccess(true);
    result.setData(list.getResult());
    return result;
  }

  @Override
  public String fileUploadVideo(HttpServletRequest request, MultipartFile upload, String title)
      throws Exception {

    if (upload.isEmpty()) {
      return "false";
    }

    if (upload == null) {
      return "false";
    }

    System.out.println(title);
    System.out.println("文件上传开始");
    // 使用fileUpload组件完成文件上传
    // 上传的位置
    String path = request.getSession().getServletContext().getRealPath("/uploads/");
    System.out.println(path);
    File file = new File(path);
    if (!file.exists()) {
      file.mkdirs();
    }
    // 获取上传文件的名称
    String fileName = upload.getOriginalFilename();
    String uuid = UUID.randomUUID().toString().replace("-", "");
    fileName = uuid + "_" + fileName;
    upload.transferTo(new File(path, fileName));
    System.out.println(fileName);
    System.out.println(request.getLocalPort());

    Video video = new Video();
    video.setVideoTitle(title);

    String inIp = "172.17.15.185"; // 内网ip
    String outIp = "39.97.126.45"; // 公网ip

    if (request.getLocalAddr().equals(inIp)) {
      video.setVideoContent(
          "http://" + outIp + ":" + request.getLocalPort() + "/uploads/" + fileName);
    }else {
      video.setVideoContent(
          "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + "/uploads/" + fileName);
      System.out.println(video.getVideoContent());
    }

    video.setVideoContent(
        "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + "/uploads/" + fileName);
    System.out.println(video.getVideoContent());
    int insert = videoService.insert(video);
    if (insert != 0) {
      return "true";
    } else {
      return "false";
    }
  }
}
