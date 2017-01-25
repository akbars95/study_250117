package com.mtsmda.book.java8.ch6.other.habra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dminzat on 12/25/2016.
 */
public class StreamTerminal {

    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Etulia");
        cities.add("Cismikioi");
        cities.add("Vulcanesty");
        cities.add("Cumai");
        cities.add("Kirillovka");
        cities.add("Svetlyi");
        cities.add("Kongaz");
        cities.add("Kirsovo");
        cities.add("Komrat");
        cities.add("Cimishliya");
        cities.add("Hyncesti");
        cities.add("Kishinev");

        Optional<String> first = cities.stream().findFirst();
        System.out.println(first + " _ " + first.isPresent() + " _ " + first.getClass() + " _ " + first.get());
        System.out.println(cities.stream().findAny().get());

        System.out.println(cities.stream().count());
        System.out.println(cities.stream().filter(city -> city.contains("i")).count());
        List<String> collect = cities.stream().filter((s) -> s.contains("i")).collect(Collectors.toList());
        System.out.println(collect.size());
        System.out.println(cities.stream().anyMatch(cur -> cur.startsWith("K")));
        System.out.println(cities.stream().anyMatch(cur -> cur.startsWith("k")));
        System.out.println(cities.stream().noneMatch(cur -> cur.startsWith("k")));
        System.out.println(cities.stream().noneMatch(cur -> cur.startsWith("K")));
        System.out.println("\n---------");
        cities.stream().sorted((o1, o2) -> o1.length() > o2.length() ? 1 : -1).forEach(cur ->  {
            System.out.println(cur + " = " + cur.length());
        });
        System.out.println(cities.stream().allMatch(cur -> cur.length() > 5));
        System.out.println(cities.stream().allMatch(cur -> cur.length() > 3));
        System.out.println(cities.stream().min((o1, o2) -> o1.length() > o2.length() ? 1 : -1).get());
        System.out.println(cities.stream().max((o1, o2) -> o1.length() > o2.length() ? 1 : -1).get());

        cities.stream().forEach(s -> System.out.println(s + " _ "));
        cities.stream().forEachOrdered(System.out::println);
        Object[] objects = cities.stream().map(String::toUpperCase).toArray();
        System.out.println(objects.length);
        String[] strings = cities.stream().map(String::toLowerCase).toArray(String[]::new);
        System.out.println(strings.length);

        cities.stream().reduce((s1, s2) -> s1.length() + s2.length() + "").get();
        List<Integer> integers = cities.stream().map(cur -> cur.length()).collect(Collectors.toList());
        System.out.println(integers.size());
        integers.stream().sorted((o1, o2) -> o1 > o2 ? 1 : -1).forEach(System.out::println);
        System.out.println(cities.stream().mapToInt(cur -> cur.length()).sum());
        System.out.println(cities.stream().mapToInt(cur -> cur.length()).average());
        Object[] objects1 = cities.stream().mapToInt(cur -> cur.length()).mapToObj(id -> new Integer(id)).toArray();
        System.out.println(objects1.length);
        System.out.println(cities.stream().isParallel());
        System.out.println(cities.parallelStream().isParallel());
        Stream<String> sequential = cities.stream().sequential();
        System.out.println(sequential.isParallel());
        Stream<String> parallel = cities.parallelStream().parallel();
        System.out.println(parallel.isParallel());

    }

}