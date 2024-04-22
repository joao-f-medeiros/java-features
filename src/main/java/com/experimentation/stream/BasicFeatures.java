package com.experimentation.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicFeatures {

    public static void main(String[] args) throws IOException {
        List<Integer> listInt = Arrays.asList(1, 5, 8, 9, 3, 5, 6, 7);

        // Generating stream from an Array
        listInt.stream()
                .map(e -> e * 2)
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        // Generating stream from an Map
        Map<Boolean, List<Integer>> map = listInt.stream()
                .collect(Collectors.groupingBy(e -> e % 2 == 0));
        System.out.println(map);

        // Joining a stream object elements
        String result = listInt.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
        System.out.println(result);

        // Generating a stream from Stream.of method
        Stream.of("All", "working", "fine")
                .forEach(System.out::println);

        // Generating a stream from Stream.iterate method
        Stream.iterate(5, n -> n * 2)
                .limit(5)
                .forEach(System.out::println);

        // Generating a stream from Arrays class
        Arrays.stream(new Integer[] { 1, 2, 3, 4, 5 })
                .forEach(System.out::println);

        // Generating a stream from IntStream class
        IntStream.range(1, 10)
                .forEach(System.out::println);

        // Generating a stream from BufferedReader class
        try (BufferedReader br = new BufferedReader(new FileReader(new File("streams.txt")))) {
            br.lines().forEach(System.out::println);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        // Generating a stream from Random class
        new Random().ints()
                .limit(10)
                .forEach(System.out::println);

        // Generating a stream from Pattern class
        Pattern pa = Pattern.compile(" ");
        pa.splitAsStream("Space example")
                .forEach(System.out::println);
    }
}
