package com.mtsmda.book.java8.ch6.other.habra;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by dminzat on 12/14/2016.
 */
public class StreamConveers {

    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("barca");
        s.add("milan");
        s.add("lion");
        s.add("marsele");

        Set<String> name = new HashSet<>();
        name.add("milan");
        name.add("barca");
        name.add("spartak");
        s.retainAll(name);
        System.out.println("s - " + s);
        System.out.println("n - " + name);

        System.out.println(name.addAll(s));
        System.out.println("concat - " + name);

        Set<String> footballClubs = new HashSet<>(s);
        footballClubs.add("barca");
        footballClubs.add("milan");
        footballClubs.add("lion");
        footballClubs.add("marsele");
        footballClubs.add("spartak");
        System.out.println(footballClubs);

        System.out.println(footballClubs.stream().filter(cur -> cur.startsWith("m") || cur.endsWith("a")).count());
        System.out.println();

        System.out.println(footballClubs.stream().count());
        System.out.println(footballClubs.stream().skip(2).count());
        footballClubs.stream().skip(2).forEach(System.out::println);
        footballClubs.stream().forEach(cur -> System.out.print(cur + ", "));
        System.out.println("---------");
        footballClubs.forEach(cur -> System.out.print(cur + ", "));

        List<String> footballPlayers = new ArrayList<>();
        footballPlayers.add("messi");
        footballPlayers.add("ronaldo");
        footballPlayers.add("torres");
        footballPlayers.add("neymar");
        footballPlayers.add("suarez");
        footballPlayers.add("ronaldo");

        System.out.println();
        System.out.println(footballPlayers.stream().count());
        System.out.println("ppppppppppp");
        System.out.println(footballPlayers.stream().distinct().count());


        System.out.println("\n--------");
        footballPlayers.stream().map(current -> current + " the best player football club").forEach(System.out::println);

        System.out.println("\n--------");
        footballPlayers.stream()/*.map(String::toUpperCase)*/.peek(current -> System.out.println(", " + current.toUpperCase())).forEach(System.out::println);
        /*LocalDateTime localDateTimeYesterday = LocalDateTime.now().minusDays(1);
        LocalDateTime localDateTimeToday = LocalDateTime.now();
        LocalDateTime localDateTimeTomorrow = LocalDateTime.now().plusDays(1);
        System.out.println(localDateTimeYesterday.isBefore(localDateTimeToday));
        System.out.println(localDateTimeTomorrow.isAfter(localDateTimeToday));

        LocalDateTime ldt141535 = LocalDateTime.of(LocalDate.of(2016, 12, 23), LocalTime.of(14, 15, 35));
        LocalDateTime ldt141540 = LocalDateTime.of(LocalDate.of(2016, 12, 23), LocalTime.of(14, 15, 40));
        System.out.println(ldt141535.isAfter(ldt141540));*/

        System.out.println(footballPlayers.stream().count());
        System.out.println("_________");
        footballPlayers.stream().forEach(System.out::println);
        System.out.println("other - _________\n");
        footballPlayers.stream().limit(5).forEach(System.out::println);
        System.out.println("================\n");
        footballPlayers.stream().sorted().forEach(System.out::println);
        System.out.println("================\n");

        footballPlayers.stream().sorted((o1, o2) -> o1.length() > o2.length() ? 1 : -1).forEach(System.out::println);

        List<Double> prices = Arrays.asList(25.15, 394D, 09.09, 23D, 9.89);
        prices.stream().forEach(System.out::println);
        double sum = prices.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println(sum);

        String[] strings = prices.stream().flatMap(cur -> Arrays.asList(cur.toString().split(".")).stream()).toArray(String[]::new);
        for (String cur : strings){
            System.out.println(cur);
        }

    }

}