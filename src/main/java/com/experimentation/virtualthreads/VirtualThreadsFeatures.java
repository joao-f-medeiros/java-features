package com.experimentation.virtual_threads;

import java.util.concurrent.Executors;

public class VirtualThreadsFeatures {

  public static void main(String[] args) {
    // Java 21 - Virtual Threads
    // Thread API
    Thread.startVirtualThread(() -> System.out.println("Virtual Thread w/ Thread API"));

    // Executors API
    var executor = Executors.newVirtualThreadPerTaskExecutor();
    executor.submit(() -> System.out.println("Virtual Thread w/ Executors API"));
  }
}
