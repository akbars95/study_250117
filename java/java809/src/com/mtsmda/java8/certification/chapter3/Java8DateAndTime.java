package com.mtsmda.java8.certification.chapter3;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by dminzat on 7/13/2016.
 */
public class Java8DateAndTime {

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(LocalDateTime.now());

        LocalDate localDate = LocalDate.of(2019, Month.FEBRUARY, 28);
        System.out.println(localDate);
        localDate = LocalDate.of(2020, 3, 31);
        System.out.println(localDate);

        System.out.println();
        LocalTime localTime = LocalTime.of(19, 00);
        localTime = LocalTime.of(19, 00, 9);
        localTime = LocalTime.of(19, 00, 19, 100_000);

        System.out.println();

        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.SEPTEMBER, 9, 19, 00);
        localDateTime = LocalDateTime.of(localDate, localTime);

        try {
            localDate = LocalDate.of(2019, 15, 32);
        }
        catch (DateTimeException e){
            System.out.println(e.getMessage() + "\t-----" + e.getClass().getCanonicalName());
        }

        //old way
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1);
        Date jan = calendar.getTime();

        Calendar calendarOther = new GregorianCalendar(2015, Calendar.JANUARY, 1);
        jan = calendarOther.getTime();

        Calendar calendarOtherWithoutConstants = Calendar.getInstance();
        calendarOtherWithoutConstants.set(2019, 2, 27);

        //date time manipulation
        dateTimeManipulation();

        System.out.println(LocalDate.of(2016, Month.AUGUST, 2).plus(Period.ofMonths(6)));
        System.out.println(LocalDate.of(2016, Month.AUGUST, 2).plus(Period.ofMonths(6)).getDayOfWeek());
    }

    private static final void dateTimeManipulation(){
        LocalDate localDate = LocalDate.of(2015, Month.APRIL, 28);
        System.out.println(localDate);
        localDate = localDate.plusDays(5);
        System.out.println(localDate);
        localDate = localDate.plusYears(9);
        System.out.println(localDate);
//        System.out.println(localDate.plus(1, ChronoUnit.MINUTES));//UnsupportedTemporalTypeException

        System.out.println("------------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        localDateTime = localDateTime.plus(5, ChronoUnit.DAYS).plusSeconds(50).minusWeeks(2);
        System.out.println(localDateTime);


        System.out.println(localDate.toEpochDay());
        periodDemo();
    }

    private static final void periodDemo(){
        System.out.println("------------period------------");
        LocalDate localDateStart = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate localDateEnd = LocalDate.of(2015, Month.MARCH, 30);
        Period period = Period.ofMonths(1);
        performAnimalEnrichment(localDateStart, localDateEnd, period);
        System.out.println("----------------");
        System.out.println(localDateEnd);
        localDateEnd = localDateEnd.plus(Period.of(1, 2, 15));
        System.out.println(localDateEnd);
        System.out.println(localDateEnd.minus(Period.ofDays(10).ofYears(6)));//chain not working, work only last

        System.out.println("************");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Period period2 = Period.ofMonths(1);
        System.out.println(localDate.plus(period2));
        System.out.println(localDateTime.plus(period2));
        try{
            System.out.println(localTime.plus(period2));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(localTime.plus(Duration.ofMinutes(19)));
        formatingDateAndTime();
    }

    private static void performAnimalEnrichment(LocalDate localDateStart, LocalDate localDateEnd,
                                                Period period){
        LocalDate upTo = localDateStart;
        while (upTo.isBefore(localDateEnd)){
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period);
        }
    }


    private final static void formatingDateAndTime(){
        System.out.println("*************\nformating");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getYear());
        System.out.println(localDate.getDayOfYear());

        System.out.println();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter dateTimeFormatterShort = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dateTimeFormatterShort.format(localDateTime));
        try {
            System.out.println(dateTimeFormatterShort.format(localTime));
        }
        catch (Exception e){
            System.out.println(e.getClass().getCanonicalName());
        }

        DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        System.out.println(localDateTime.format(myDateTimeFormatter));

        DateTimeFormatter dateTimeFormatterHourAndMinute = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(dateTimeFormatterHourAndMinute.format(localTime));
        try{
            System.out.println(dateTimeFormatterHourAndMinute.format(localDate));
        }
        catch(Exception e){
            System.out.println(e.getClass().getCanonicalName());
        }
        System.out.println(dateTimeFormatterHourAndMinute.format(localDateTime));

        //parsing date and time
        System.out.println(LocalTime.parse("19:05"/*, dateTimeFormatterHourAndMinute*/));
//        System.out.println(LocalTime.parse("19:05:09", DateTimeFormatter.ofPattern("hh:mm:ss")));
        System.out.println(LocalDateTime.parse("19:05:03 20.05.2011", DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy")));

        System.out.println(LocalDate.parse("01 02 2015", DateTimeFormatter.ofPattern("MM dd yyyy")));

    }
}