package com.mtsmda.book.java8.ch8;

import java.time.*;
import java.time.zone.ZoneRulesException;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LLocalDate {

    public static void main(String[] args) {
        LocalDate localDateNow = LocalDate.now();
        System.out.println("Now " + localDateNow);

        LocalDate localDate = LocalDate.of(2016, 10, 20);
        System.out.println(localDate);
        localDate = LocalDate.of(2016, Month.FEBRUARY, 25);
        System.out.println(localDate);

        localDate = LocalDate.of(10_000, 2, 10);
        System.out.println(localDate);

        try{
            localDate = LocalDate.of(2016, 15, 10);
        }
        catch (DateTimeException e){
            System.out.println(e.getMessage());
        }

        localDate = LocalDate.now(ZoneId.systemDefault());
        System.out.println(localDate);
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        System.out.println(ZoneId.getAvailableZoneIds().size());
        localDate = LocalDate.now(ZoneId.of("Europe/Moscow"));
        System.out.println(localDate);
        localDate = LocalDate.now(ZoneId.of("Europe/Chisinau"));
        System.out.println(localDate);
        try {
            localDate = LocalDate.now(ZoneId.of("Europe/Komrat"));
            System.out.println(localDate);
        }catch (ZoneRulesException e){
            System.out.println(e.getMessage());
        }

        localDate = LocalDate.now(Clock.systemUTC());
        System.out.println(localDate);

        localDate = LocalDate.ofYearDay(2016, 99);
        System.out.println("99 day of 2016 year - " + localDate);

        localDate = LocalDate.parse("2016-10-26");
        System.out.println(localDate);

        localDate = LocalDate.ofEpochDay(500);
        System.out.println(localDate);
        System.out.println(localDate.minusDays(500));

    }

}