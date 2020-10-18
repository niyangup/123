package com.niyang.base.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 空判断工具类.
 *
 * @author niyangup
 * @since 2020-02-22 15:39
 */
public class CheckEmptyUtil {
  public CheckEmptyUtil() {}

  public static boolean isEmpty(Object object) {
    if (object == null) {
      return true;
    } else {
      if (object instanceof String) {
        String str = (String) object;
        if (str.trim().length() == 0) {
          return true;
        }
      }

      if (object instanceof CharSequence) {
        CharSequence cs = (CharSequence) object;
        if (cs.length() == 0) {
          return true;
        }

        if (cs.toString().trim().length() == 0) {
          return true;
        }
      }

      if (object instanceof List) {
        List<?> list = (List) object;
        return list.isEmpty();
      } else {
        if (object.getClass().isArray()) {
          Object[] array = (Object[]) ((Object[]) object);
          if (array.length == 0) {
            return true;
          }
        }

        if (object instanceof Map) {
          Map<?, ?> map = (Map) object;
          return map.isEmpty();
        } else if (object instanceof Set) {
          Set<?> set = (Set) object;
          return set.isEmpty();
        } else {
          return false;
        }
      }
    }
  }

  public static boolean isNotEmpty(Object object) {
    return !isEmpty(object);
  }

  public static boolean isOrEmpty(Object... objects) {
    if (objects != null && objects.length != 0) {
      Object[] var1 = objects;
      int var2 = objects.length;

      for (int var3 = 0; var3 < var2; ++var3) {
        Object object = var1[var3];
        if (isEmpty(object)) {
          return true;
        }
      }

      return false;
    } else {
      return true;
    }
  }

  public static boolean isAndEmpty(Object... objects) {
    if (objects != null && objects.length != 0) {
      Object[] var1 = objects;
      int var2 = objects.length;

      for (int var3 = 0; var3 < var2; ++var3) {
        Object object = var1[var3];
        if (!isEmpty(object)) {
          return false;
        }
      }

      return true;
    } else {
      return true;
    }
  }
}
