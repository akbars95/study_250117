package com.mtsmda.book.java8.ch6;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by dminzat on 11/8/2016.
 */
public class LStream {

    public static void main(String[] args) {
        long count = Stream.of(1, 10, 25, 322, 24).map(i -> i * i * 10).count();
        System.out.printf("The stream has %d elements", count);

        System.out.println();

        count = Stream.of(12,856, 21232, 8451).map(i -> i ^ 2).peek(number -> System.out.printf("number - %d", number)).count();
        System.out.println("count = " + count);

        System.out.println();

        Stream.of(15, 25, 390, 2405, 85).peek(number -> System.out.print(number)).map(number -> number * 2).peek(number -> System.out.println(" - after - " + number)).count();

        System.out.println();
        System.out.println("sum = " + DoubleStream.of(4.0, 81.0, 625).map(Math::sqrt).peek(System.out::println).sum());
    }

}