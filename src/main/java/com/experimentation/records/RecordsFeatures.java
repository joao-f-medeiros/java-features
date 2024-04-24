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
  }
}
