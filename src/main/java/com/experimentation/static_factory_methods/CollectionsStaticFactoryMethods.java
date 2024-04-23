package com.experimentation.static_factory_methods;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsStaticFactoryMethods {

  public static void main(String[] args) {
    // Before Java 9
    List<Integer> list = Arrays.asList(1, 2, 3);

    // After Java 9 - Immutable
    List<Integer> listEmpty = List.of();
    List<Integer> list1 = List.of(1);
    List<Integer> list2 = List.of(1, 2);
    List<Integer> list3 = List.of(1, 2, 3);

    Set<Object> setEmpty = Set.of();
    Set<Object> set1 = Set.of(1);
    Set<Object> set2 = Set.of(1, 2);
    Set<Object> set3 = Set.of(1, 2, 3);

    Map<Object, Object> mapEmpty = Map.of();
    Map<String, Integer> map1 = Map.of("A", 1);
    Map<String, Integer> map2 = Map.of("A", 1, "B", 2);
    Map<String, Integer> map3 = Map.of("A", 1, "B", 2, "C", 3);
  }
}