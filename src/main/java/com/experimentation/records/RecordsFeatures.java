package com.experimentation.records;

import java.util.List;

public class RecordsFeatures {

  public static void main(String[] args) {
    Product product = new Product("Coffe", 4, 2.50);
    System.out.println(product.name());
    System.out.println("Total price " + product.getTotalValue());
    List.of(new Product("Chocolat", 10, 11.00)).forEach(System.out::println);

    // Java 16 - Inner Records
    record TempRecord(String name) {
    }
    TempRecord temp = new TempRecord("Java 15");
    System.out.println(temp.name());

    interface MyInterface {
    }
    System.out.println(MyInterface.class);

    enum WEEK_DAYS {
      SUNDAY, MONDAY
    }
    System.out.println(WEEK_DAYS.MONDAY);

    patternMatchingWithRecords(product);
  }

  // Java 21 - Pattern Matching with Records
  private static void patternMatchingWithRecords(Object obj) {
    if (obj instanceof Product(String name, int quantity, double price)) {
      System.out.println("Product name " + name);
      System.out.println("Product quantity " + quantity);
    }

    switch (obj) {
      case Product(String name, int quantity, double price) -> System.out.println(name);
      default -> System.out.println("Invalid Object");
    }
  }
}
