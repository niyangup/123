package com.niyang.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间转换工具类.
 *
 * @author niyangup
 * @since 2020-02-22 15:40
 */
public class DateUtil {
  private static final Pattern UNIX_TIMESTAMP_PATTERN = Pattern.compile("^\\d{10}$");
  private static final Pattern JAVA_TIMESTAMP_PATTERN = Pattern.compile("^\\d{13}$");
  private static final Pattern STANDARD_DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
  private static final Pattern SLASH_DATE_PATTERN = Pattern.compile("^\\d{4}/\\d{2}/\\d{2}$");
  private static final String ERROR_PARSE_STR = "error parse ";
  private static final String DEFAULT_FORMAT_VALUE = "EEE MMM dd HH:mm:ss zzz yyyy";
  private static final String STANDARD_DATE_FORMAT_VALUE = "yyyy-MM-dd";
  private static final String STANDARD_DATE_TIME_FORMAT_VALUE = "yyyy-MM-dd HH:mm:ss";
  private static final String DETAIL_STANDARD_DATE_TIME_FORMAT_VALUE = "yyyy-MM-dd HH:mm:ss,SSS";
  private static final String SLASH_DATE_FORMAT_VALUE = "yyyy/MM/dd";
  private static final String SLASH_DATE_TIME_FORMAT_VALUE = "yyyy/MM/dd HH:mm:ss";
  private static final String DETAIL_SLASH_DATE_TIME_FORMAT_VALUE = "yyyy/MM/dd HH:mm:ss,SSS";
  private static final String STR_STANDARD_DATE_FORMAT_VALUE = "yyyyMMdd";
  private static final String SD_FORMAT_YYYY_MM_VALUE = "yyyyMM";

  public DateUtil() {}

  private static Date parse10Text(String newText) {
    try {
      Matcher matcher = UNIX_TIMESTAMP_PATTERN.matcher(newText);
      Matcher standardMatcher = STANDARD_DATE_PATTERN.matcher(newText);
      Matcher slashMatcher = SLASH_DATE_PATTERN.matcher(newText);
      if (matcher.matches()) {
        return new Date(Long.parseLong(newText + "000"));
      } else {
        SimpleDateFormat slashDateFormat;
        if (standardMatcher.matches()) {
          slashDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          return slashDateFormat.parse(newText);
        } else if (slashMatcher.matches()) {
          slashDateFormat = new SimpleDateFormat("yyyy/MM/dd");
          return slashDateFormat.parse(newText);
        } else {
          throw new IllegalArgumentException("wrong 10 length date format:" + newText);
        }
      }
    } catch (Exception var5) {
      throw new IllegalArgumentException("wrong 10 length date format:" + newText, var5);
    }
  }

  private static Date parse13Text(String newText) {
    Matcher matcher = JAVA_TIMESTAMP_PATTERN.matcher(newText);
    if (matcher.matches()) {
      return new Date(Long.parseLong(newText));
    } else {
      throw new IllegalArgumentException("wrong java timestamp format:" + newText);
    }
  }

  private static Date parse19Text(String newText) {
    try {
      SimpleDateFormat slashDateTimeFormat;
      if (newText.contains("-")) {
        slashDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return slashDateTimeFormat.parse(newText);
      } else {
        slashDateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return slashDateTimeFormat.parse(newText);
      }
    } catch (ParseException var2) {
      throw new IllegalArgumentException(
          "error parse " + newText + " to Date with standard format", var2);
    }
  }

  private static Date parse23Text(String newText) {
    try {
      SimpleDateFormat detailSlashDateTimeFormat;
      if (newText.contains("-")) {
        detailSlashDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        return detailSlashDateTimeFormat.parse(newText);
      } else {
        detailSlashDateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss,SSS");
        return detailSlashDateTimeFormat.parse(newText);
      }
    } catch (ParseException var2) {
      throw new IllegalArgumentException(
          "error parse " + newText + " to Date with detail standard format", var2);
    }
  }

  private static Date parseDefaultText(String newText) {
    try {
      SimpleDateFormat defaultFormat =
          new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
      return defaultFormat.parse(newText);
    } catch (ParseException var2) {
      throw new IllegalArgumentException(
          "error parse " + newText + " to Date with default format", var2);
    }
  }

  public static Date convertToDate(String text) {
    if (text != null && text.trim().length() != 0) {
      String newText = text.trim();
      int length = newText.length();
      switch (length) {
        case 10:
          return parse10Text(newText);
        case 13:
          return parse13Text(newText);
        case 19:
          return parse19Text(newText);
        case 23:
          return parse23Text(newText);
        default:
          return parseDefaultText(newText);
      }
    } else {
      return null;
    }
  }

  public static String getStrDate(Date date) {
    if (date == null) {
      return "";
    } else {
      SimpleDateFormat strStandardDateFormat = new SimpleDateFormat("yyyyMMdd");
      return strStandardDateFormat.format(date);
    }
  }

  public static String getyyyyMm(Date date) {
    if (date == null) {
      return "";
    } else {
      SimpleDateFormat sdFormatYyyyMm = new SimpleDateFormat("yyyyMM");
      return sdFormatYyyyMm.format(date);
    }
  }

  public static Date getDayBegin(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    resetTime(calendar);
    return calendar.getTime();
  }

  public static Date getDayEnd(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    resetTimeEnd(calendar);
    return calendar.getTime();
  }

  public static Date getMonthBegin(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(5, 1);
    resetTime(calendar);
    return calendar.getTime();
  }

  public static Date getYearBegin(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(2, 0);
    calendar.set(5, 1);
    resetTime(calendar);
    return calendar.getTime();
  }

  private static void resetTime(Calendar calendar) {
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(14, 0);
  }

  private static void resetTimeEnd(Calendar calendar) {
    calendar.set(11, 23);
    calendar.set(12, 59);
    calendar.set(13, 59);
    calendar.set(14, 999);
  }

  public static String formatStandardDateTime(Date date) {
    SimpleDateFormat standardDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return standardDateTimeFormat.format(date);
  }

  public static String formatStandardDate(Date date) {
    SimpleDateFormat standardDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return standardDateFormat.format(date);
  }

  public static Date parseStandardDate(String dateStr) {
    return parse10Text(dateStr);
  }

  public static Date parseStandardDateTime(String dateStr) {
    return parse19Text(dateStr);
  }

  public static String getMonthFirstDay(Calendar calendar) {
    calendar.set(5, calendar.getActualMinimum(5));
    return formatStandardDate(calendar.getTime());
  }

  public static String getMonthLastDay(Calendar calendar) {
    calendar.set(5, calendar.getActualMaximum(5));
    return formatStandardDate(calendar.getTime());
  }

  public static String getMonthFirstDayHms(Calendar calendar) {
    calendar.set(5, 1);
    resetTime(calendar);
    return formatStandardDateTime(calendar.getTime());
  }

  public static String getMonthLastDayHms(Calendar calendar) {
    calendar.set(5, 1);
    resetTime(calendar);
    calendar.add(2, 1);
    calendar.add(13, -1);
    return formatStandardDateTime(calendar.getTime());
  }

  public static Date getDateAfter(Date date, int day) {
    Calendar now = Calendar.getInstance();
    now.setTime(date);
    now.add(5, day);
    resetTime(now);
    return now.getTime();
  }

  public static LocalDate getDateAfter(LocalDate localDate, long day) {
    localDate = localDate.plusDays(day);
    return localDate;
  }
}
