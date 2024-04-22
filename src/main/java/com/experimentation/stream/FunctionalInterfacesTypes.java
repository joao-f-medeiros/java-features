package com.experimentation.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class FunctionalInterfacesTypes {

  public static void main(String[] args) {
    // Suplier - Receive nothing, return value
    Stream.generate(() -> new Random().nextInt())
        .limit(5)
        // Consumer - Receive value, return nothing
        // BiConsumer - Receive two values, return nothing
        .forEach((e) -> System.out.println(e));

    Arrays.asList(1, 2, 3, 4, 5).stream()
        // Predicate - Receive value, return a test result (boolean test)
        // BiPredicate - Receive two values, return a test result (boolean test)
        .filter(e -> e % 2 == 0)
        // Function - Receive value, return value
        // BiFunction - Receive two values, return value
        .map(e -> e.doubleValue())
        // UnaryOperator - Receive value, return value same type
        // BinaryOperator - Receive two values, return value same type
        .reduce((e1, e2) -> e1 + e2)
        .ifPresent(System.out::println);
  }
}
