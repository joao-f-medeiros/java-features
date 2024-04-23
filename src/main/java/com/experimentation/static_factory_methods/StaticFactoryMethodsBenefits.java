package com.experimentation.static_factory_methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StaticFactoryMethodsBenefits {

  public static void main(String[] args) {
    // Significant Names
    Optional<Object> empty = Optional.empty();
    Optional<Integer> onHundredOpt = Optional.of(100);
    Optional<Object> nullable = Optional.ofNullable(null);

    // Flexible Returns
    List<Object> list = new ArrayList<>();
    List<Object> newList = Collections.unmodifiableList(list);
    // newList.add(2); throw exception

    // Instance Control
    Integer onHundred = Integer.valueOf(100);
  }
}
