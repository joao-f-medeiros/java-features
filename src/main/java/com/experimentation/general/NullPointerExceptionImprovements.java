package com.experimentation.general;

public class NullPointerExceptionImprovements {

  public static void main(String[] args) {
    String[][] matriz = new String[5][5];
    matriz[1] = new String[5];
    // matriz[1][0] = "Java 14";

    if (matriz[1][0].toUpperCase().equals("s")) {

    }
  }
}
