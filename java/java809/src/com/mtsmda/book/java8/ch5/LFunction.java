package com.mtsmda.book.java8.ch5;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dminzat on 11/8/2016.
 */
public class LFunction {

    public static void main(String[] args) {
        Arrays.stream("-4, -9, 25".split(", ")).map(Integer::parseInt).map(i -> (i < 0) ? -i : i).forEach(System.out::println);

        System.out.println("_________________________");

        Function<String, Integer> strLength = text -> text.length();
        System.out.println(strLength.apply("This city is very good!"));

        Function<Integer, String> getLetters = number -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < number; i++) {
                long current = Math.round(Math.random() * (i + 35));
                result.append((char) current);
            }
            return result.toString();
        };

        String apply = getLetters.apply(25);
        System.out.println(apply);
        System.out.println(apply.length() == 25);

        System.out.println("_________________________");

        Function<String, Integer> parseInt = Integer::parseInt;
        Function<Integer, Integer> absInt = Math::abs;
        Function<String, Integer> parseAndAbs = parseInt.andThen(absInt);

        Arrays.stream("4, -9, 16, -25, 36".split(", ")).map(parseAndAbs).forEach(System.out::println);

        System.out.println("_________________________");
        Function<String, Integer> beforeCompose = absInt.compose(parseInt);
        Arrays.stream("4, -9, 16, -25, 36".split(", ")).map(beforeCompose).forEach(System.out::println);

        System.out.println("_________________________");
        Arrays.stream("4, -9, 16, -25, 36".split(", ")).map(Function.identity()).forEach(System.out::println);

        System.out.println("_________________________");
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Stream.generate(atomicInteger::incrementAndGet).limit(10).forEach(System.out::println);

        IntStream.generate(atomicInteger::incrementAndGet).limit(5).forEach(System.out::println);

        Function<Integer, Integer> createInt = Integer::new;
        System.out.println(createInt.apply(15));

        IntFunction<String> createIntToString = Integer::toString;
        System.out.println(createIntToString.apply(195) + "120");

        ToIntFunction<String> toIntFunction = Integer::parseInt;
        System.out.println(toIntFunction.applyAsInt("153"));

        DoubleToIntFunction doubleToIntFunction = (multiply) -> (int) (Math.random() * multiply);
        System.out.println(doubleToIntFunction.applyAsInt(150.95));

    }

}