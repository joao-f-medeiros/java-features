package com.experimentation.general;

public class StringFeatures {

  public static void main(String[] args) {
    String s = "   My Java Code    ";
    System.out.println(s.isBlank());
    System.out.println(s.lines());
    System.out.println(s.repeat(3));
    System.out.println(s.strip()); // Trim better, should use always
    System.out.println(s.stripLeading()); // Remove empty space ahead of the String
    System.out.println(s.stripTrailing()); // Remove empty space before of the String
  }
}
