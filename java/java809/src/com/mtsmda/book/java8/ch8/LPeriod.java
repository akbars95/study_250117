package com.mtsmda.book.java8.ch8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LPeriod {

    public static void main(String[] args) {
        LocalDate localDate2013 = LocalDate.of(2013, 6, 26);
        Period period = Period.between(localDate2013, LocalDate.now());
        System.out.println(period);
        System.out.println("w - " + period.getDays() + " days, " + period.getMonths() + " months, " + period.getYears() + " years");

        System.out.println(Period.between(LocalDate.now(), LocalDate.of(2017, 1,1)));

        System.out.println(Period.ofDays(4));
        System.out.println(Period.ofMonths(6));
        System.out.println(Period.ofWeeks(5));
        System.out.println(Period.ofYears(2));

        System.out.println(Period.parse("P4Y3M356D"));
        try{
            System.out.println(Period.parse("P4Y3M17Dc"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

}