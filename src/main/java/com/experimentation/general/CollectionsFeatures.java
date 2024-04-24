package com.experimentation.general;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFeatures {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>() {
      {
        add(1);
        add(2);
        add(3);
        add(4);
      }
    };

    // Java 21 - Sequenced Collections
    list.addFirst(0);
    list.addLast(5);

    System.out.println("Get last element " + list.getLast());
    System.out.println("Get first element " + list.getFirst());
    System.out.println("Remove first element " + list.removeFirst());
    System.out.println("Remove last element " + list.removeLast());
  }
}
