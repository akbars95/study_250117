package com.mtsmda.book.java8.other;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by dminzat on 12/12/2016.
 */
public class UnixTime {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime() / 1000);
        date = new Date(1485585157753L);
        System.out.println(date);
    }

}