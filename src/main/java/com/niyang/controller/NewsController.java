package com.niyang.controller;

import com.github.pagehelper.Page;
import com.niyang.api.NewsApi;
import com.niyang.base.util.CheckEmptyUtil;
import com.niyang.base.util.RestControllerResult;
import com.niyang.base.util.SaveUtil;
import com.niyang.domain.News;
import com.niyang.service.NewsService;
import java.io.File;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author niyangup
 * @since 2020-02-25 20:48
 */
@RestController
public class NewsController implements NewsApi {

  @Resource NewsService newsService;

  @Override
  public News findById(Integer id) {
    return newsService.findById(id);
  }

  @Override
  public RestControllerResult<Page<News>> findByPage(
      Integer pageNum, Integer pageSize, Integer cateId) {
    RestControllerResult<Page<News>> result = new RestControllerResult();

    if (CheckEmptyUtil.isOrEmpty(pageNum, pageSize, cateId)) {
      result.setSuccess(false);
      result.setErrorMsg("请输入必填参数");
      return result;
    }
    result.setSuccess(true);
    result.setData(newsService.findByPage(cateId, pageNum, pageSize));
    return result;
  }

  @Override
  public String fileUploadNews(
      HttpServletRequest request,
      MultipartFile upload,
      String title,
      String desc,
      String content,
      String categoryId)
      throws Exception {
    if (upload.isEmpty()) {
      return "false";
    }
    if (CheckEmptyUtil.isOrEmpty(title, desc, content, categoryId)) {
      return "false";
    }

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
    System.out.println(path + ":" + fileName);

    News news = new News();
    news.setNewsTitle(title);
    news.setNewsDesc(desc);
    news.setNewsContent(content);
    news.setCateId(Integer.parseInt(categoryId));

    String inIp = "172.17.15.185"; // 内网ip
    String outIp = "39.97.126.45"; // 公网ip

    if (request.getLocalAddr().equals(inIp)) {
      news.setNewsPic("http://" + outIp + ":" + request.getLocalPort() + "/uploads/" + fileName);
      // 设置新闻内容文件
      String newFileName = SaveUtil.save(content, path, fileName);

      news.setNewsShareUrl(
          "http://" + outIp + ":" + request.getLocalPort() + "/uploads/" + newFileName);

    } else {
      news.setNewsPic(
          "http://"
              + request.getLocalAddr()
              + ":"
              + request.getLocalPort()
              + "/uploads/"
              + fileName);
      // 设置新闻内容文件
      String newFileName = SaveUtil.save(content, path, fileName);

      news.setNewsShareUrl(
          "http://"
              + request.getLocalAddr()
              + ":"
              + request.getLocalPort()
              + "/uploads/"
              + newFileName);
    }

    int insert = newsService.insert(news);
    if (insert != 0) {
      return "true";
    } else {
      return "false";
    }
  }
}
