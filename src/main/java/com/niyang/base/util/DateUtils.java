package com.niyang.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 工具类：[日期]、[字符串]、[时间]三者的转换工具类 三者的转换是非常常用的，所以定义此工具类。三者的简要说明如下： [日期]：日期对象 [字符串]：指的是日期的字符串表示.
 * [时间]：long型的值
 */
public class DateUtils {
  /** 日期格式枚举. */
  public enum DateFormatter {
    // 日期格式枚举
    DATE_PATTERN_CHINESE("yyyy年MM月dd日"),
    DATE_PATTERN_LINE("yyyy-MM-dd"),
    DATE_PATTERN_SLASH("yyyy/MM/dd"),
    DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
    DATE_PATTERN_NONE("yyyyMMdd");

    // 日期格式化
    private transient DateTimeFormatter formatter;

    DateFormatter(String pattern) {
      this.formatter = DateTimeFormatter.ofPattern(pattern);
    }
  }

  private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

  public static final String DATETIMEFORMAT = "yyyyMMddHHmmss";

  public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

  public static final long TIME_OF_MINUTE = 60000L;

  public static final long TIME_OF_HOUR = 3600000L;

  public static final long TIME_OF_DAY = 86400000L;

  /**
   * 将[日期]按照给定的[日期格式]转成[字符串].
   *
   * @param date 日期
   * @param format 日期格式
   * @return
   */
  public static String parseDateToString(Date date, String format) {
    if (date == null) {
      return null;
    }
    if (StringUtils.isEmpty(format)) {
      format = DATE_TIME_FORMAT;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }

  /**
   * 将[时间]按照指定的[日期格式]转成[字符串].
   *
   * @param time 时间
   * @param format 日期格式
   * @return
   */
  public static String parseLongToString(long time, String format) {
    SimpleDateFormat mydate = new SimpleDateFormat(format);
    return mydate.format(new Date(time));
  }

  /**
   * 将[字符串]按照指定的[日期格式]转成[时间].
   *
   * @param time 字符串
   * @param format 日期格式
   * @return
   */
  public static long parseStringToLong(String time, String format) {
    SimpleDateFormat mydate = new SimpleDateFormat(format);
    try {
      Date date = mydate.parse(time);
      if (date != null) {
        return date.getTime();
      }
    } catch (ParseException e) {
      logger.error("Date parse error:", e);
    }
    return 0;
  }

  /**
   * 将[字符串]按照指定的[日期格式]转成[日期].
   *
   * @param time 字符串
   * @param format 日期格式
   * @return
   */
  public static Date parseStringToDate(String time, String format) {
    SimpleDateFormat mydate = new SimpleDateFormat(format);
    try {
      Date date = mydate.parse(time);
      if (date != null) {
        return date;
      }
    } catch (ParseException e) {
      logger.error("Date parse error:", e);
    }
    return null;
  }

  /**
   * 添加天数.
   *
   * @param date 日期
   * @param amount 增加天数
   * @return
   */
  public static Date addDay(Date date, int amount) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    calendar.add(Calendar.DAY_OF_MONTH, amount);

    return calendar.getTime();
  }

  /**
   * 添加天数.
   *
   * @param date 日期
   * @param amount 增加天数
   * @return
   */
  public static Date addMonth(Date date, int amount) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    calendar.add(Calendar.MONTH, amount);

    return calendar.getTime();
  }

  /**
   * 减少分钟数.
   *
   * @param date 日期
   * @param minite 分钟
   * @return
   */
  public static  Date subMinute(Date date, int minite) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.MINUTE, minite);
    return calendar.getTime();
  }

  /**
   * 减少秒数.
   *
   * @param date 日期
   * @param second 秒
   * @return
   */
  public static  Date addSeconds(Date date, int second) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.SECOND, second);
    return calendar.getTime();
  }

  /**
   * 增加小时数.
   *
   * @param date 日期
   * @param amount 增加小时数 往前则为负数
   * @return
   */
  public static Date addHour(Date date, int amount) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    calendar.add(Calendar.HOUR_OF_DAY, amount);

    return calendar.getTime();
  }

  /**
   * 获取某天的开始时间.
   *
   * @param date 日期
   */
  public static Date getStartTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTime();
  }

  /**
   * 获取某天的结束时间.
   *
   * @param date 日期
   */
  public static Date getEndTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    return calendar.getTime();
  }

  /**
   * 根据给定的日期、天数、日期格式化计算出给定日期前XXX天的日期，并返回String类型.
   *
   * @param localDate 给定的日期
   * @param days 天数
   * @param dateFormatter 日期格式化
   * @return
   */
  public static String getMinusLocalDate(
      LocalDate localDate, long days, DateFormatter dateFormatter) {
    LocalDate resultLocalDate = localDate.minusDays(days);
    return dateFormatter.formatter.format(resultLocalDate);
  }

  /**
   * 根据给定的日期、天数、日期格式化计算出给定日期后XXX天的日期，并返回String类型.
   *
   * @param localDate 给定的日期
   * @param days 天数
   * @param dateFormatter 日期格式化
   * @return
   */
  public static String getPlusLocalDate(
      LocalDate localDate, long days, DateFormatter dateFormatter) {
    LocalDate resultLocalDate = localDate.plusDays(days);
    return dateFormatter.formatter.format(resultLocalDate);
  }

  /**
   * 获取当前时间前后XXX天0点的时间戳.
   *
   * @param day 天数
   */
  public static Date getBeforeTime(int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH) - day,
        0,
        0,
        0);
    return calendar.getTime();
  }

  /**
   * 时间格式化.
   *
   * @param date date
   * @return
   */
  public static String convertDate(Date date, String dateFormat) {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(date);
  }
}
