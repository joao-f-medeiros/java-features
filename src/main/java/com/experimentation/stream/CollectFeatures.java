package com.experimentation.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectFeatures {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

    // Collector customized: Supplier - Accumulator - Combiner
    ArrayList<Object> collect = list.stream()
        .collect(
            // Suplier initialization
            () -> new ArrayList<>(),
            // Accumulator: l - Suplier collection, e - element of the stream
            (l, e) -> l.add(e),
            // Combiner: l1 and l2 - Collections merge
            (l1, l2) -> l1.addAll(l2));

    System.out.println(list);
    System.out.println(collect);

    // toList
    List<Integer> collect2 = list.stream()
        .collect(Collectors.toList());
    System.out.println(collect2);

    // toSet
    Set<Integer> collect3 = list.stream()
        .collect(Collectors.toSet());
    System.out.println(collect3);

    // toCollection - Customize return type
    LinkedList<Integer> collect4 = list.stream()
        .collect(Collectors.toCollection(() -> new LinkedList<>()));
    System.out.println(collect4);

    // joining - Merge all the elements
    String join = list.stream()
        .map(e -> e.toString())
        .collect(Collectors.joining(","));
    System.out.println(join);

    // averaging - Avery of the elements value
    Double average = list.stream()
        .collect(Collectors.averagingInt(n -> n.intValue()));
    System.out.println(average);

    // summing - Sumary of the stream, only one value
    Integer sum = list.stream()
        .collect(Collectors.summingInt(n -> n.intValue()));
    System.out.println(sum);

    // sumarizing - Process all the values together
    IntSummaryStatistics stats = list.stream()
        .collect(Collectors.summarizingInt(n -> n.intValue()));
    System.out.println(stats.getAverage());
    System.out.println(stats.getCount());
    System.out.println(stats.getMax());
    System.out.println(stats.getMin());
    System.out.println(stats.getSum());

    // counting
    Long count = list.stream()
        .collect(Collectors.counting());
    System.out.println(count);

    // max/min
    list.stream()
        .collect(Collectors.maxBy(Comparator.naturalOrder()))
        .ifPresent(System.out::println);

    list.stream()
        .collect(Collectors.minBy(Comparator.naturalOrder()))
        .ifPresent(System.out::println);

    // groupingBy
    Map<Integer, List<Integer>> grouping = list.stream()
        .collect(Collectors.groupingBy(n -> n % 2));

    System.out.println(grouping);

    // partitioningBy
    Map<Boolean, List<Integer>> partitioning = list.stream()
        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

    System.out.println(partitioning);

    // toMap
    Map<Integer, Integer> toMap = list.stream()
        .collect(Collectors.toMap(
            // Key value definition
            n -> n,
            // Value definition
            n -> n * 2));

    System.out.println(toMap);
  }
}
