package com.mtsmda.book.java8.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.ToIntBiFunction;

/**
 * Created by dminzat on 11/8/2016.
 */
public class BiFunctionalInterface {

    public static void main(String[] args) {
        BiFunction<String, String, String> stringStringStringBiFunction = (x, y) -> x + ", " + y;
        System.out.println(stringStringStringBiFunction.apply("number#1", "number#2"));

        BiFunction<Double, Double, Integer> doubleDoubleIntegerBiFunction = Double::compare;
        System.out.println(doubleDoubleIntegerBiFunction.apply(10.95, 11.01));

        ToIntBiFunction<String, String> countOfSizeStr = (str1, str2) -> str1.length() + str2.length();
        System.out.println(countOfSizeStr.applyAsInt("Ivanovici", "Messi"));

        BiPredicate<List<String>, String> searchTextInList = (list, text) -> list.contains(text);
        List<String> strings = Arrays.asList("Barcelona", "Milan", "Chelsea", "MU", "Bayern");
        System.out.println(searchTextInList.test(strings, "MU"));
        System.out.println(searchTextInList.test(strings, "mu"));

        BiConsumer<List<Integer>, Integer> addIntToList = List::add; /*(list, integer) -> list.add(integer)*/;
        List<Integer> numbers = new ArrayList<>();
        addIntToList.accept(numbers, 19);
        addIntToList.accept(numbers, 19 * 2);
        addIntToList.accept(numbers, 36);
        addIntToList.accept(numbers, 95);
        System.out.println(numbers.size());
    }

}