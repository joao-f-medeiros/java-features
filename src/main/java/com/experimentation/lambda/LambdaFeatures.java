package com.experimentation.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LambdaFeatures {

  public static void main(String[] args) {
    listLambdaCode();
    mapLambdaCode();
  }

  private static void mapLambdaCode() {
    HashMap<Integer, String> map = new HashMap<>();
    map.put(0, "HashMap");
    map.put(1, "lambda");
    map.put(2, "code");
    map.put(3, "example");

    // Update the registry from key param according to the body expression
    map.compute(1, (k, v) -> v + " da baixa");

    // Merge the registry from key, passing a new value and the function wil receive
    // v1 (actual map value) and v2 (new value that was passed). The body should
    // merge the two values. If key does not exist, creates a new registry with key
    // and value informed only, without execute the function
    map.merge(0, "!", (v1, v2) -> v1 + v2);

    // Replace all the values with the expression inside lambda function
    map.replaceAll((k, v) -> v + "!");

    // Iterates over the map to execute some code without return
    map.forEach((k, v) -> System.out.println(k + v));
  }

  private static void listLambdaCode() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    // Remove if the condition is true
    list.removeIf(n -> n % 2 == 0);
    // Replace the value with the expression inside lambda function
    list.replaceAll(n -> n * 2);
    // Iterates over the list to execute some code without return
    list.forEach(n -> System.out.println(n));

    // Debugging lambda and stream codes
    list.stream()
        // Is used for debug or add logs inside a stream
        .peek(n -> System.out.println("Number " + n + " will execute"))
        .filter(n -> n % 2 == 0)
        .peek(n -> System.out.println("Number " + n + " is even"))
        .map((n) -> new StringBuilder().append(n).append("s").append("a"))
        .forEach(System.out::println);
  }

}
