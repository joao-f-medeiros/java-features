package com.experimentation.general;

import java.util.List;

public class VarFeatures {

  public static void main(String[] args) {
    canDo();

    canNotDo();
  }

  private static void canDo() {
    // Very usefull to avoid repetion of declarations, specially when name very big
    // Ex: ByteArrayInputStream bais = new ByteArrayInputStream(null);
    var i = 50;
    var name = "Java 10" + i;
    var description = getDescription(); // Not very clear to understand and read

    List<String> list = List.of("One", "new", name, description);
    for (var element : list) {
      System.out.println(element);
    }
    var list2 = List.of("One", "new", name, description);
    list2.forEach(System.out::println);

    var stringOrInteger = list2.size() > 0 ? "ABC" : 23;
    System.out.println("IntersectionType = " + stringOrInteger.toString());
  }

  private static void canNotDo() {
    // var anything; Always assign a value to var at initialization
    // var i = null; Same problem of not initializing the var

    // Can not change to var
    Runnable r = () -> System.out.println("My runnable");
    r.run();

    // Can not be used as Method param, Constructors param or Method return
    // Attributes of class cannot be a var
    // Catch exception can not use var
  }

  private static String getDescription() {
    return "Description";
  }
}
