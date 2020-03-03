package com.bau.tools.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FileUtilsTest {

  @Test
  public void readAllLines() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/file"));
    List<String> lines = FileUtils.readAllLines(reader);
    for (String line : lines) {
      System.out.println(line);
    }
    assertEquals(3, lines.size());

    reader.close();
  }
}
