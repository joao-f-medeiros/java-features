package com.experimentation.general;

public class StringFeatures {

  public static void main(String[] args) {
    String str = "   My Java Code    ";
    System.out.println(str.isBlank());
    System.out.println(str.lines());
    System.out.println(str.repeat(3));
    System.out.println(str.strip()); // Trim better, should use always
    System.out.println(str.stripLeading()); // Remove empty space ahead of the String
    System.out.println(str.stripTrailing()); // Remove empty space before of the String

    String java12 = "Java 12 Features";
    System.out.println(java12.indent(2));
    System.out.println(java12.transform(s -> s + " Nice!").transform(String::toUpperCase));
  }
}
