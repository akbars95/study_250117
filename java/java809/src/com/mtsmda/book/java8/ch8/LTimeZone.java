package com.mtsmda.book.java8.ch8;

import java.time.*;
import java.time.zone.ZoneRulesException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by dminzat on 11/9/2016.
 */
public class LTimeZone {

    public static void main(String[] args) {
        System.out.println(ZoneId.systemDefault());

        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        System.out.println(ZoneId.getAvailableZoneIds().size());
        System.out.println(ZoneId.of("America/Los_Angeles"));

        try {
            System.out.println(ZoneId.of("America/Odessa"));
        }catch (ZoneRulesException e){
            System.out.println(e.getMessage());
        }

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()));

        Map<ZoneOffset, Integer> zoneOffsetIntegerMap = new TreeMap<>();
        ZoneId.getAvailableZoneIds().forEach(current ->{
            ZoneOffset offset = LocalDateTime.now(ZoneId.of(current)).atZone(ZoneId.of(current)).getOffset();
            if(zoneOffsetIntegerMap.containsKey(offset)){
                zoneOffsetIntegerMap.put(offset, zoneOffsetIntegerMap.get(offset) + 1);
            }else{
                zoneOffsetIntegerMap.put(offset, 1);
            }
        });
        System.out.println("size - " + zoneOffsetIntegerMap.size());

        zoneOffsetIntegerMap.forEach((key, value) ->{
            System.out.println("Zone offset " + key + " = " + value);
        });

        LocalDateTime localDateTime = LocalDateTime.of(2017, 1, 1, 0, 0);
        ZoneId singaporeZone = ZoneId.of("Asia/Singapore");
        ZonedDateTime zonedDateTimeSingapore = ZonedDateTime.of(localDateTime, singaporeZone);

        ZoneId zoneIdChisinau = ZoneId.of("Europe/Chisinau");
        ZonedDateTime zonedDateTimeChisinau = ZonedDateTime.of(localDateTime, zoneIdChisinau);

        Duration duration = Duration.between(zonedDateTimeSingapore, zonedDateTimeChisinau);
        System.out.println(duration + ", hours = " + duration.getSeconds() / 3600);

    }

}