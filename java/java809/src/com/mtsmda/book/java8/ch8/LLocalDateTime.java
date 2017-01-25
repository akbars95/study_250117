package com.mtsmda.book.java8.ch8;

import java.time.LocalDateTime;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LLocalDateTime {

    public static void main(String[] args) {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println(localDateTimeNow);

        LocalDateTime localDateTimeChristmas = LocalDateTime.of(2016, 12, 25, 0, 0);
        LocalDateTime localDateTimeNewYear = LocalDateTime.of(2017, 1, 1, 0, 0);
        System.out.println("New Year 2017 comes after Christmas 2016? " + localDateTimeNewYear.isAfter(localDateTimeChristmas));

        System.out.println(localDateTimeNow.toLocalDate());
        System.out.println(localDateTimeNow.toLocalTime());

        System.out.println();



    }

}