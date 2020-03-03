package com.bau.tools.utils;

import org.apache.commons.lang3.RegExUtils;

public final class PlaceHolderUtils {

  public static final String REGEX = "\\?";

  public static String replace(String stringToReplace, String data, String splitRegex) {
    String stringReplaced = stringToReplace;
    if (stringToReplace != null && data != null) {
      String[] dataArray = data.split(splitRegex);
      for (String d : dataArray) {
        stringReplaced = RegExUtils.replaceFirst(stringReplaced, REGEX, d);
      }
    }
    return stringReplaced;
  }
}
