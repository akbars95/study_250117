package com.mtsmda.book.java8.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by dminzat on 11/8/2016.
 */
public class LUnaryOperator {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(-11, 22, -33, 44, 55, -66, 77);
        System.out.println(integers);
        integers.replaceAll(Math::abs);
        System.out.println(integers);

        UnaryOperator<String> stringUnaryOperator = s -> s.toString() + "Text";
        System.out.println(stringUnaryOperator.apply("Test! "));
    }

}