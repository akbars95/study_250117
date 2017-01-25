package com.mtsmda.book.java8.ch5;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.stream.Stream;

/**
 * Created by dminzat on 11/8/2016.
 */
public class LConsumer {

    public static void main(String[] args) {
        //1 way
        Stream.of("hello", "world").forEach(System.out::println);

        //2 way
        Stream<String> stringStream = Stream.of("barca", "milan");
        Consumer<String> printString = System.out::println;
        stringStream.forEach(printString);

        System.out.println("_________________________");

        Consumer<String> toUpperCaseWithPrint = text -> System.out.println(text.toUpperCase());
        for(String current : Arrays.asList("new", "barca", "good", "cPU")){
            toUpperCaseWithPrint.accept(current);
        }

        Consumer<StringBuilder> reverse = text -> text.reverse();
        Consumer<StringBuilder> stringBuilderConsumerPrint = System.out::println;
        Consumer<StringBuilder> consumerReverseWithPrint = reverse.andThen(stringBuilderConsumerPrint);
        consumerReverseWithPrint.accept(new StringBuilder("test"));

        Consumer<StringBuilder> consumerPrintAndReverse = stringBuilderConsumerPrint.andThen(reverse);
        consumerPrintAndReverse.accept(new StringBuilder("good ram"));

        IntConsumer intConsumerMultiply100 = (integer) -> System.out.println(integer * 100);
        intConsumerMultiply100.accept(159);

        ObjIntConsumer<String> stringObjIntConsumer = (name, age) -> System.out.println("Her name is - " + name + ", he is " + age + " age");
        stringObjIntConsumer.accept("Vasilii", 12);
    }

}