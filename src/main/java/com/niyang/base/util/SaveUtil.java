package com.niyang.base.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 保存新闻内容工具类.
 *
 * @author niyangup
 * @since 2020-03-08 16:15
 */
public class SaveUtil {
  public static String save(String content, String path, String fileName) {
    String newName = fileName.substring(0, fileName.lastIndexOf(".")) + ".html";
    try {
      File file = new File(path, newName);
      BufferedWriter writer =
          new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
      writer.write(content);
      writer.close();
      return newName;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
