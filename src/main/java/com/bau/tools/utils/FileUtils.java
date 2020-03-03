package com.bau.tools.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FileUtils {

  public static List<String> readAllLines(BufferedReader reader) throws IOException {
    List<String> lines = new ArrayList<String>();
    String line;

    while ((line = reader.readLine()) != null) {
      lines.add(line);
    }

    return lines;
  }
}
