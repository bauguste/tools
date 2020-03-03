package com.bau.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.bau.tools.utils.FileUtils;
import com.bau.tools.utils.PlaceHolderUtils;

public class Application {

  public static void main(String[] args) throws ParseException {
    final Options options = new Options();

    final Option fileOption =
        Option.builder("f").longOpt("file").desc("File").hasArg(true).required(true).build();
    final Option lineOption =
        Option.builder("l").longOpt("line").desc("Line").hasArg(true).required(true).build();
    final Option splitOption =
        Option.builder("s")
            .longOpt("split")
            .desc("Split RegEx")
            .hasArg(true)
            .required(true)
            .build();

    options.addOption(fileOption);
    options.addOption(lineOption);
    options.addOption(splitOption);

    final CommandLineParser parser = new DefaultParser();
    final CommandLine line = parser.parse(options, args);

    for (Option option : line.getOptions()) {
      System.out.println(option.getArgName() + ":" + option.getValue());
    }

    String fileName = line.getOptionValue("file");
    String stringToReplace = line.getOptionValue("line");
    String splitRegex = line.getOptionValue("split");

    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new FileReader(fileName));
      List<String> lines = FileUtils.readAllLines(bufferedReader);
      for (String l : lines) {
        System.out.println(PlaceHolderUtils.replace(stringToReplace, l, splitRegex));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
