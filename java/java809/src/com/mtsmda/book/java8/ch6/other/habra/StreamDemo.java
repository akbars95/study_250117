package com.mtsmda.book.java8.ch6.other.habra;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dminzat on 1/9/2017.
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a1", "a2", "a3", "b4", "b8", "c10", "d17", "g95", "v102");
        System.out.println(strings.stream().filter(cur -> cur.startsWith("a")).count());

        System.out.println(strings.stream().findFirst().orElse("0!"));
        System.out.println(Arrays.asList().stream().findFirst().orElse("Not found!"));
        System.out.println(strings.stream().skip(strings.size() - 1).findAny().orElse("empty"));
        System.out.println(strings.stream().skip(strings.size() - 0).findAny().orElse("empty"));
        System.out.println(strings.stream().skip(strings.size() - -9).findAny().orElse("empty"));
//        System.out.println(strings.stream().filter(cur -> cur.equals("a5")).findFirst().orElseThrow(NullPointerException::new));
        System.out.println(strings.stream().skip(2).findFirst().get());
        Object[] objects = strings.stream().skip(1).limit(2).toArray();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
        for (Object o : objects){
            System.out.println("o = " + o);
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
        strings.stream().filter(cur -> cur.startsWith("a") || cur.startsWith("b")).collect(Collectors.toList()).forEach(cur -> System.out.println(cur));

        streamWithObject();

        List<String> newStringList = new ArrayList<>();

        strings.stream().forEach(cur -> newStringList.add(cur));

        newStringList.add("a2");
        newStringList.add("v102");
        System.out.println(newStringList.stream().count());
        System.out.println(newStringList.stream().distinct().count());

        System.out.println("---------------------------------------------------------------");

        System.out.println(strings.stream().anyMatch("a1"::equals));
        System.out.println(strings.stream().anyMatch("a10"::equals));
        System.out.println(strings.stream().allMatch("a10"::contains));
        System.out.println(strings.stream().allMatch("w"::contains));
        System.out.println(strings.stream().noneMatch("w"::contains));

        System.out.println("---------------------------------------------------------------");
        System.out.println("MAPS");
        List<String> stringList = Arrays.asList("12.0", "253.53", "953.4");
        stringList.stream().map(cur -> cur.concat("-1")).forEach(cur -> System.out.println(cur));
        int[] ints = stringList.stream().mapToInt(cur -> Integer.parseInt(cur.substring(0, 1))).toArray();
        for (int i : ints){
            System.out.println(i);
        }

        String[] strings1 = stringList.stream().flatMap(s -> Arrays.asList(s.split("\\.")).stream()).toArray(String[]::new);
        System.out.println(strings1);
        System.out.println(stringList.stream().flatMap(s -> Arrays.asList(s.split("\\.")).stream()).count());

        System.out.println(stringList.stream().flatMap(cur -> Arrays.asList(cur.split("\\.")).stream()).mapToInt(Integer::parseInt).sum());
        System.out.println("/*-*/*-*");
        strings.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("/*-*/*-*");
        strings.stream().sorted(((o1, o2) -> o2.compareTo(o1))).forEach(cur -> System.out.print(cur + "\t"));
        System.out.println(strings.stream().max((o1, o2) -> new Integer(o1.length()).compareTo(o2.length())).isPresent());

        strings.stream().peek(s -> s += ("_peek")).forEach(System.out::println);

        Stream<StringBuilder> stringBuilderStream = Stream.of(new StringBuilder("first"), new StringBuilder("second"));
        stringBuilderStream.peek(stringBuilder -> stringBuilder.append("_new")).forEach(stringBuilder -> System.out.println(stringBuilder));

        List<Integer> integers = Arrays.asList(152, 90, 243, 943, 7312);
        System.out.println(integers.stream().reduce((s1, s2) -> s1 + s2).orElse(0));
        System.out.println(integers.stream().reduce(Integer::max).orElse(-1));
        System.out.println(integers.stream().reduce(Integer::min).orElse(-1));
        System.out.println(integers.stream().filter(integer -> integer % 2 != 0).reduce(Integer::min).orElse(-1));
        Set<Integer> collectSet = integers.stream().collect(Collectors.toSet());
        System.out.println(collectSet.size());
        List<Integer> collectList = integers.stream().collect(Collectors.toList());
        System.out.println(collectList.size());

        System.out.println("||||||||||||||||||||||||||||||");
        System.out.println(integers.stream().collect(Collectors.summingInt((p) -> p % 2 == 0 ? p : 0)));
        System.out.println(integers.stream().collect(Collectors.summarizingInt((p) -> p % 2 == 0 ? p : 0)).getMax());
        System.out.println(integers.stream().collect(Collectors.summarizingInt((p) -> p % 2 != 0 ? p : 0)).getMax());
        integers.stream().collect(Collectors.partitioningBy(p -> p % 2 == 0)).forEach((aBoolean, integers1) -> {
            System.out.println(aBoolean + " = ");
            integers1.stream().forEach(integer -> System.out.println("\t" + integer));
        });

        List<Integer> collect = integers.stream().collect(Collectors.toList());
        System.out.println(collect.size());
        String[] toArray = strings.stream().map(String::toUpperCase).toArray(String[]::new);
        System.out.println(toArray.length);
        for (String cur : toArray){
            System.out.println(cur);
        }

    }

    private static void streamWithObject(){
        System.out.println("---------------------------------------------------------------");
        List<People> peoples = Arrays.asList(new People("Ivan", 19, People.Gender.MALE), new People("Afonya", 29, People.Gender.MALE),
                new People("Dusya", 60, People.Gender.FEMALE), new People("Gufi", 30, People.Gender.MALE),
                new People("Evgheniya", 55, People.Gender.FEMALE));
        System.out.println(peoples.stream().filter(cur -> cur.getGender().equals(People.Gender.MALE) && cur.getAge().intValue() >= 18 && cur.getAge().intValue() <= 27).count());
        List<People> collect = peoples.stream().filter(cur -> cur.getGender().equals(People.Gender.MALE) && cur.getAge().intValue() >= 18 && cur.getAge().intValue() <= 27).collect(Collectors.toList());
        System.out.println(collect.size());
        collect.forEach(cur -> System.out.println(cur.toString()));

        System.out.println(peoples.stream().filter(cur -> cur.getGender().equals(People.Gender.MALE)).mapToInt(People::getAge).average());
        System.out.println(peoples.stream().filter(cur -> cur.getGender().equals(People.Gender.FEMALE)).mapToInt(People::getAge).average());
        System.out.println(peoples.stream().mapToInt(People::getAge).average());
        System.out.println(peoples.stream().filter(cur -> (cur.getAge() >= 18 && cur.getAge() < 62 && cur.getGender() == People.Gender.MALE)
                || (cur.getAge() >= 18 && cur.getAge() < 57 && cur.getGender() == People.Gender.FEMALE)).count());



    }

}

class People{
    private String name;
    private Integer age;
    private Gender gender;

    public People() {

    }

    public People(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public enum Gender{
        MALE, FEMALE;


    }

}