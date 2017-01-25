package com.mtsmda.book.java8.ch6.other.com.studytrails;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by dminzat on 12/8/2016.
 */
public class StreamEx {

    public static void main(String[] args) {
        List<String> genre = new ArrayList<>(Arrays.asList("rock", "pop", "jazz", "classic"));
        long count = genre.stream().filter(current -> current.startsWith("r") || current.endsWith("c")).count();
        System.out.println(count);

        System.out.println(genre.stream().allMatch(text -> !text.isEmpty()));
        genre.add("");
        System.out.println(genre.stream().allMatch(text -> !text.isEmpty()));
        genre.removeIf(text -> text.isEmpty());
        System.out.println(genre);
        System.out.println(genre.stream().anyMatch(cur -> cur.indexOf("r") == 0));
        System.out.println(genre.stream().anyMatch(cur -> cur.indexOf("R") == 0));

        System.out.println("\\\\\\\\\\");

        System.out.println(genre.stream().peek(cur -> System.out.println(cur)).anyMatch(cur -> cur.indexOf("r") == 0));
        System.out.println(genre.stream().peek(cur -> System.out.println(cur)).count());

        System.out.println(genre.stream().filter(s -> s.length() <= 4).count());

        genre.stream().forEach(System.out::println);

        System.out.println("\\\\\\\\\\");

        Optional<String> reduce = genre.stream().reduce((b, c) -> b.concat(",").concat(c));
        System.out.println(reduce.get());

        Integer reduce1 = genre.stream().reduce(0, (b, c) -> b + c.length(), (b, c) -> b + c);
        System.out.println(reduce1);


        HashSet<String> collect = genre.stream().collect(() -> new HashSet<String>(), (b, c) -> b.add(c), (b, c) -> b.addAll(c));
        System.out.println(collect);

        List<String> strings = Arrays.asList("Name", "Family");
        Optional<String> name = strings.stream().filter(s -> s.equals("Name") || s.equals("family")).findFirst();
        System.out.println(name.get());
        System.out.println(strings.stream().filter(s -> s.equals("name") || s.equals("family")).count());
    }

}