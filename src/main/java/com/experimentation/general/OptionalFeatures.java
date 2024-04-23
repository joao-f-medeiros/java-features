package com.experimentation.general;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalFeatures {

  public static void main(String[] args) {
    String s = Optional.of("29").orElse("0");
    Integer number = convertToNumber(s).orElse(1);

    System.out.println(number);

    int numberConverted = Integer.parseInt(s);
    OptionalInt integer = OptionalInt.of(numberConverted);
    System.out.println(integer.getAsInt());

    Optional.of(number).orElseThrow(() -> new IllegalArgumentException());
    Optional.of(number).orElseThrow();
  }

  public static Optional<Integer> convertToNumber(String numberStr) {
    Integer number = Integer.valueOf(numberStr);
    return Optional.of(number);
  }
}
