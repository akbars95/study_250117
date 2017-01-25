package com.mtsmda.java8.certification.zjava8Demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dminzat on 8/8/2016.
 */
public class StreamDemo {

    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 25; i <= 25 * 10; i += 25) {
            integers.add(i);
        }
        List<Integer> filtered = integers.stream().filter(integer -> integer % 50 == 0).collect(Collectors.toList());
        filtered.forEach(System.out::println);

        Integer integerOptional = integers.stream().filter(integer -> integer > 250).findAny().orElse(300);
        System.out.println(integerOptional.toString());

        List<Person> personList = Arrays.asList(new Person("Ion", 25), new Person("Vasile", 90), new Person("Petru", 53));
        String result = personList.stream().filter(person -> {
            return person.getAge() > 5;
        }).map(Person::getName).findAny().orElse("nothing");
        System.out.println(result);

        System.out.println("??????????????????????");

        List<Person> persons = Arrays.asList(
                new Person("Ionel", "Chisinau"),
                new Person("Ivan", "Moskva"), new Person("Dmitro", "Kiev"), new Person("Ostap", "Kiev"));

        Map<String, List<Person>> stringListMap = persons.stream().collect(Collectors.groupingBy(Person::getCity));
        System.out.println(stringListMap);
    }

}

class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}