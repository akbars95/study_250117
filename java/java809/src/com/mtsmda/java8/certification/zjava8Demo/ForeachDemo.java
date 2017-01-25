package com.mtsmda.java8.certification.zjava8Demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dminzat on 8/8/2016.
 */
public class ForeachDemo {

    public static void main(String[] args) {
//        char a = 'A';
//        System.out.println((int)a);
        foreachMap();
        System.out.println("/n****************************");
        foreachList();
    }

    private static void foreachMap(){
        Map<String, Integer> items = new LinkedHashMap<>();
        for(int i = 10, j = 65 + 9; i <= 100; i+=10, j--){
            items.put(new String("" + (char)j), i);
        }

        for (Map.Entry<String, Integer> entry : items.entrySet()){
            System.out.println("key - " + entry.getKey() + "\tvalue - " + entry.getValue());
        }

        System.out.println("java 8");
        //java 8
        items.forEach((key, value) -> System.out.println("key - " + key + "\tvalue - " + value));

        items.forEach((k, v) -> {
            if(v.equals(90)){
                System.out.print("this is good! \t");
            }
            System.out.println("key - " + k + "\tvalue - " + v);
        });
    }

    private static void foreachList(){
        List<Integer> integers = new ArrayList<>();
        for(int i = 25; i <= 25*10; i+=25){
            integers.add(i);
        }

        for (Integer integer : integers){
            System.out.println(integer);
        }

        System.out.println("java 8");
        //java 8
        integers.forEach(value -> System.out.println(value));

        integers.forEach(System.out::println);

        integers.stream().forEach(System.out::println);
    }

}