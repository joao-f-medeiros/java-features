package com.experimentation.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceFeatures {

  public static void main(String[] args) {
    String s = "Um Novo Teste Aqui";
    String[] split = s.split(" ");
    List<String> listStr = Arrays.asList(split);
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

    list.stream()
        .reduce((n1, n2) -> n1 + n2)
        .ifPresent(System.out::println);

    list.stream()
        .reduce((n1, n2) -> n1 * n2)
        .ifPresent(System.out::println);

    listStr.stream()
        .reduce((s1, s2) -> s1.concat(s2))
        .ifPresent(System.out::println);

    // Not recommended to use subtract with Reduce, is not garanteed
    list.stream()
        .reduce((n1, n2) -> n1 - n2)
        .ifPresent(System.out::println);

    Integer sum2 = list.stream()
        .reduce(0, (n1, n2) -> n1 + n2);
    System.out.println(sum2);

    Integer multiply2 = list.stream()
        .reduce(1, (n1, n2) -> n1 * n2);
    System.out.println(multiply2);

    String concatenate2 = listStr.stream()
        .reduce("", (s1, s2) -> s1.concat(s2));
    System.out.println(concatenate2);

    String sum3 = list.stream()
        .reduce(
            "",
            (n1, n2) -> n1.toString().concat(n2.toString()),
            (n1, n2) -> n1 + n2);
    System.out.println(sum3);
  }
}
