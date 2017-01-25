package com.mtsmda.book.java8.ch5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dminzat on 11/8/2016.
 */
public class LPredicate {

    public static void main(String[] args) {
        Stream.of("hello", "world").filter(str -> str.startsWith("h")).forEach(System.out::println);

        System.out.println("___________");

        Predicate<String> stringPredicate = text -> text.length() > 5;
        Stream.of("hello", "brasil", "ion", "sun", "oracle").filter(stringPredicate).forEach(System.out::println);

        System.out.println("___________");

        Predicate<String> nullCheck = text -> null != text;
        Predicate<String> emptyCheck = text -> text.isEmpty();
        Predicate<String> notEmptyCheck = emptyCheck.negate();
        Predicate<String> notNullAndNotEmptyCheck = nullCheck.and(notEmptyCheck);
        String hello = "hello";
        System.out.println(nullCheck.test(hello));
        System.out.println(emptyCheck.test(hello));
        System.out.println(notEmptyCheck.test(hello));
        System.out.println(notNullAndNotEmptyCheck.test(hello));
        System.out.println(notNullAndNotEmptyCheck.test(null));

        System.out.println("___________");

        List<String> greeting = new ArrayList<>();
        greeting.add("hello");
        greeting.add("world");
        greeting.removeIf(str -> !str.startsWith("h"));
        greeting.forEach(System.out::println);

        Predicate<String> nullOrEmpty = nullCheck.negate().or(emptyCheck);
        System.out.println(nullOrEmpty.test(null));
        System.out.println(nullOrEmpty.test(""));
        System.out.println(nullOrEmpty.test("        "));

        System.out.println("___________");

        IntStream.range(1, 11).filter(i -> (i % 2) == 0).forEach(System.out::println);
        System.out.println("======");
        IntPredicate intPredicate = input -> input > 5;
        IntStream.range(1, 10).filter(intPredicate).forEach(System.out::println);

        DoublePredicate doublePredicate = (currentDouble) -> (currentDouble > 0 && currentDouble < 11);
        System.out.println(doublePredicate.test(17));

        LongPredicate longPredicate = (c) -> (c > 10 || c < 0);
        System.out.println(longPredicate.test(9));
        System.out.println(longPredicate.test(11));
    }

}