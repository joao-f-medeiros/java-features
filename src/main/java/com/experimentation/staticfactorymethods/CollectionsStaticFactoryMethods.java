package com.experimentation.staticfactorymethods;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsStaticFactoryMethods {

  public static void main(String[] args) {
    java9Methods();

    java10Methods();
  }

  private static void java10Methods() {
    List.copyOf(List.of(1));

    Set.copyOf(List.of(1));

    Map.copyOf(Map.of("A", 1));
  }

  private static void java9Methods() {
    // Before Java 9
    Arrays.asList(1, 2, 3);

    // After Java 9 - Immutable
    List.of();
    List.of(1);
    List.of(1, 2);
    List.of(1, 2, 3);

    Set.of();
    Set.of(1);
    Set.of(1, 2);
    Set.of(1, 2, 3);

    Map.of();
    Map.of("A", 1);
    Map.of("A", 1, "B", 2);
    Map.of("A", 1, "B", 2, "C", 3);
  }
}