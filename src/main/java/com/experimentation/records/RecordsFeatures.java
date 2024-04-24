package com.experimentation.records;

import java.util.List;

public class RecordsFeatures {

  public static void main(String[] args) {
    Product product = new Product("Coffe", 4, 2.50);
    System.out.println(product.name());
    List.of(new Product("Chocolat", 10, 11.00)).forEach(System.out::println);
  }
}
