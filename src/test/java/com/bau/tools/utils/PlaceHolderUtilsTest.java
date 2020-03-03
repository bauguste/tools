package com.bau.tools.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlaceHolderUtilsTest {

  @Test
  public void replaceTest() {
    String data = "test,another,another2";
    String splitRegex = ",";

    String stringToReplace = "data1 = ? data2 = ? data3 = ? end";
    String stringExpected = "data1 = test data2 = another data3 = another2 end";
    System.out.println(PlaceHolderUtils.replace(stringToReplace, data, splitRegex));
    assertEquals(stringExpected, PlaceHolderUtils.replace(stringToReplace, data, splitRegex));

    stringToReplace = "data1 = ? data2 = ? data3 = ?";
    stringExpected = "data1 = test data2 = another data3 = another2";
    System.out.println(PlaceHolderUtils.replace(stringToReplace, data, splitRegex));
    assertEquals(stringExpected, PlaceHolderUtils.replace(stringToReplace, data, splitRegex));

    data = "test,another";
    stringToReplace = "data1 = ? data2 = ? data3 = ?";
    stringExpected = "data1 = test data2 = another data3 = ?";
    System.out.println(PlaceHolderUtils.replace(stringToReplace, data, splitRegex));
    assertEquals(stringExpected, PlaceHolderUtils.replace(stringToReplace, data, splitRegex));

    data = "test,another,another2,another3";
    stringToReplace = "data1 = ? data2 = ? data3 = ?";
    stringExpected = "data1 = test data2 = another data3 = another2";
    System.out.println(PlaceHolderUtils.replace(stringToReplace, data, splitRegex));
    assertEquals(stringExpected, PlaceHolderUtils.replace(stringToReplace, data, splitRegex));
  }
}
