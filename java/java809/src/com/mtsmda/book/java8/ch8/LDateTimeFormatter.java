package com.mtsmda.book.java8.ch8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LDateTimeFormatter {

    public static void main(String[] args) {
        System.out.println(DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now()));
        List<String> patterns = Arrays.asList("dd-MM-yyyy HH':'mm':'ss.SSSSSSSSS", "d '('E')' MMM, YYYY",
                "w'th week of' YYYY", "EEEE, dd'th' MMMMM, YYYY");
        patterns.forEach(currentPattern ->{
            System.out.println(currentPattern + " = " +
                    DateTimeFormatter.ofPattern(currentPattern).format(LocalDateTime.now()));
        });

    }

}