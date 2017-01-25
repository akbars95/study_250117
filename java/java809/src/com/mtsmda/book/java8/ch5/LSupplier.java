package com.mtsmda.book.java8.ch5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by dminzat on 11/8/2016.
 */
public class LSupplier {

    public static void main(String[] args) {
        Random random = new Random();
        Stream.generate(random::nextBoolean).limit(15).forEach(System.out::println);

        System.out.println("___________");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        System.out.println("___________");
        Stream.generate(random::nextLong).limit(5).forEach(System.out::println);

        System.out.println("___________");
        Stream.generate(random::nextInt).limit(5).forEach(System.out::println);

        Function<Integer, Integer> randomIntWithBound = random::nextInt;
        for(int i = 0; i < 100; i++){
            System.out.println(randomIntWithBound.apply(100));
        }

        System.out.println("___________");
        Supplier<String> getSupplier = () ->{
                List<String> autos = Arrays.asList("BMW", "Mercedes", "Audi", "Gazeli", "Jiguli");
                return autos.get(random.nextInt(autos.size()));
        };

        Map<String, Integer> resultCountOfAuto = new LinkedHashMap<>();

        for (int i = 0; i < 100; i++){
            String current = getSupplier.get();
            if(resultCountOfAuto.containsKey(current)){
                resultCountOfAuto.put(current, resultCountOfAuto.get(current) + 1);
            }else{
                resultCountOfAuto.put(current, 1);
            }
            System.out.println(current);
        }

        System.out.println("/////");
        resultCountOfAuto.forEach((key, value) ->{
            System.out.println(key + " = " + value);
        });

        System.out.println(resultCountOfAuto.size());

        System.out.println("___________");

        Supplier<String> currentDateTime = () -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"));
        System.out.println(currentDateTime.get());

        System.out.println("___________");

        Supplier<String> newString = String::new;
        System.out.println(newString.get());

        newString = () -> new String();
        System.out.println(newString.get());

        System.out.println("___________");

        Function<String, Integer> createInteger = Integer::new;
        System.out.println(createInteger.apply("150"));

        BooleanSupplier booleanSupplier = () -> new Random().nextBoolean();
        System.out.println(booleanSupplier.getAsBoolean());

    }

}