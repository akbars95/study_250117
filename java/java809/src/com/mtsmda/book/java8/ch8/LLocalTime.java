package com.mtsmda.book.java8.ch8;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LLocalTime {

    public static void main(String[] args) {
        LocalTime localTimeNow = LocalTime.now();
        System.out.println(localTimeNow);

        System.out.println(LocalTime.of(12, 10));
        System.out.println(LocalTime.of(12, 10, 15));
        System.out.println(LocalTime.of(12, 10, 15, 1_000));

        System.out.println(LocalTime.now(Clock.systemUTC()));
        System.out.println(LocalTime.now(ZoneId.of("Europe/Moscow")));

        try{
            System.out.println(LocalTime.ofSecondOfDay(86404));
        }catch (DateTimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println(LocalTime.ofSecondOfDay(1));
        System.out.println(LocalTime.ofSecondOfDay(0));
        System.out.println(LocalTime.ofSecondOfDay(86399));
        System.out.println(LocalTime.ofSecondOfDay(60));
        System.out.println(LocalTime.ofSecondOfDay(61));

        System.out.println(LocalTime.ofNanoOfDay(61_000_000_000L));

        System.out.println(LocalTime.parse("19:35:21"));
    }

}