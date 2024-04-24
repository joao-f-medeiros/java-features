package com.experimentation.staticfactorymethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StaticFactoryMethodsBenefits {

  public static void main(String[] args) {
    // Significant Names
    Optional.empty();
    Optional.of(100);
    Optional.ofNullable(null);

    // Flexible Returns
    List<Object> list = new ArrayList<>();
    List<Object> newList = Collections.unmodifiableList(list);
    newList.forEach(System.out::println);
    // newList.add(2); throw exception

    // Instance Control
    Integer.valueOf(100);
  }
}
