package com.mtsmda.book.java8.ch8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LDuration {

    public static void main(String[] args) {
        Duration between = Duration.between(LocalDateTime.now(),  LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT));
        System.out.println(between);
    }

}