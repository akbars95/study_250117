package com.mtsmda.book.java8.ch6.other.habra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dminzat on 12/13/2016.
 */
public class StreamCreating {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(19, 35, 92).stream();

        Stream<String> stringStream = Stream.of("19", "32");

        double [] arDoubles = {15.25, 92.1432};
        DoubleStream doubleStream = Arrays.stream(arDoubles);

        try {
            Files.lines(Paths.get("D:\\work\\github\\java\\java\\java809\\.idea\\misc.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        IntStream chars = "123".chars();

        Stream<Object> string = Stream.builder().add("String").add(" hello").build();

        Stream<String> stringStream1 = Arrays.asList("sds").parallelStream();

        Stream<Integer> iterate = Stream.iterate(1, n -> n + 20);
        Stream<String> generate = Stream.generate(() -> "a1");

    }

}