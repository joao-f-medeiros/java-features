package com.experimentation.records;

public record Product(String name, int quantity, double price) implements Comparable<Product> {

  private static int COUNT = 0;

  // Construct is optional, use it only if needs to execute some code for the
  // params
  public Product(String name, int quantity, double price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    count();
  }

  private static void count() {
    COUNT++;
    System.out.println(COUNT);
  }

  @Override
  public int compareTo(Product o) {
    return this.name.compareTo(o.name());
  }
}
