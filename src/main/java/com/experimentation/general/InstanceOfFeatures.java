package com.experimentation.general;

public class InstanceOfFeatures {

  public static void main(String[] args) {
    Integer n = 50;
    handleNumber(n);
  }

  private static void handleNumber(Object obj) {
    // Before Java 14
    if (obj instanceof Integer) {
      Integer number = (Integer) obj;
      System.out.println(number.getClass());
    }

    // After Java 14
    if (obj instanceof Integer number && number < 100) {
      System.out.println(number.getClass());
    }
  }
}
