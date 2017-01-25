package com.mtsmda.book.java8.ch8;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LInstant {

    public static void main(String[] args) {
        Instant instantNow = Instant.now();
        System.out.println(instantNow);

        System.out.println("Unix seconds - " + instantNow.getEpochSecond());
        System.out.println("Unix milliseconds - " + instantNow.toEpochMilli());

        System.out.println(LocalDateTime.now());
    }

}