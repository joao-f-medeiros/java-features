package com.experimentation.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamFeatues {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4);

    // forEach - Does not garantee order
    list.parallelStream()
        .forEach(System.out::println);

    list.parallelStream()
        .forEachOrdered(System.out::println);

    // findAny - Will return any element
    list.parallelStream()
        .findAny()
        .ifPresent(System.out::println);

    // unordered - Use unordered when using distinct, skip, limit
    list.parallelStream()
        .unordered()
        .distinct()
        .skip(1)
        .limit(2)
        .forEach(System.out::println);

    // toMap - Always use ConcurrentMap so only one Map object will be created
    Map<Integer, Boolean> collect = list.parallelStream()
        .collect(Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0));
    System.out.println(collect);

    // groupingBy - Always use grouping with concurrent so only one collection
    // object will be created
    Map<Boolean, List<Integer>> collect2 = list.parallelStream()
        .collect(Collectors.groupingByConcurrent(n -> n % 2 == 0));
    System.out.println(collect2);
  }
}
