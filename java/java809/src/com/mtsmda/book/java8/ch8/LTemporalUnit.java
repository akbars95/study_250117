package com.mtsmda.book.java8.ch8;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LTemporalUnit {

    public static void main(String[] args) {
        for(ChronoUnit current : ChronoUnit.values()){
            System.out.println(current);
            System.out.println(current.isDateBased());
            System.out.println(current.isTimeBased());
            System.out.println(current.getDuration());
            System.out.println("_______________");
        }

        System.out.println(Duration.of(1, ChronoUnit.MINUTES).getSeconds());
        System.out.println(Duration.of(2, ChronoUnit.HOURS).getSeconds());
        System.out.println(Duration.of(3, ChronoUnit.DAYS).getSeconds());
    }

}