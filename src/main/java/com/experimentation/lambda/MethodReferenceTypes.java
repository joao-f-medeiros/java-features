package com.experimentation.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceTypes {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Simple method reference
        list.forEach(System.out::println);

        // Static Methods Reference
        // No Method Reference
        list.stream()
                .map(n -> multiplyBeTwo(n))
                .forEach(System.out::println);

        // With Method Reference
        list.stream()
                .map(MethodReferenceTypes::multiplyBeTwo)
                .forEach(System.out::println);

        // Method References for Constructors
        // No Method Reference
        list.stream()
                .map(n -> new BigDecimal(n))
                .forEach(System.out::println);

        // No Method Reference
        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);

        // Multiple Instances
        // No Method Reference
        list.stream()
                .map(n -> n.doubleValue())
                .forEach(System.out::println);

        // With Method Reference
        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        // One Instance
        // No Method Reference
        BigDecimal two = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map(b -> two.multiply(b))
                .forEach(System.out::println);

        // With Method Reference
        list.stream()
                .map(BigDecimal::new)
                .map(two::multiply)
                .forEach(System.out::println);
    }

    private static Integer multiplyBeTwo(Integer i) {
        return i * 2;
    }
}
