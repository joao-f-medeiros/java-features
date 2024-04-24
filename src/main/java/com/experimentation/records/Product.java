package com.experimentation.records;

// Java 16
// Can not extend other classes, only implement
// Records are immutable (all fields are final)
// Empty constructor doesn't exist because the class is immutable
// Construct is optional, only if needs to execute some code for the params
// Records can not be used for JPA or Hibernates because both need empty constructor and getter and setters
public record Product(String name, int quantity, double price) implements Comparable<Product> {

  private static int COUNT = 0;

  // Can have static methods
  private static void count() {
    COUNT++;
    System.out.println(COUNT);
  }

  // Can have methods
  public double getTotalValue() {
    count();
    return quantity * price;
  }

  @Override
  public int compareTo(Product o) {
    return this.name.compareTo(o.name());
  }
}
