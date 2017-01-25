package com.mtsmda.java8.certification.chapter3;

/**
 * Created by dminzat on 7/8/2016.
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        String alpha = "";
        StringBuilder stringBuilder = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++){
            alpha += current;
            stringBuilder.append(current);
        }
        System.out.println(alpha);
        System.out.println(stringBuilder);
        System.out.println(new StringBuilder("webar.niculescu").reverse());

        StringBuilder capacity = new StringBuilder("capacity");
        System.out.println(capacity.length());
        System.out.println(capacity.capacity());

        System.out.println(new StringBuilder().capacity());
        System.out.println(new StringBuilder(1).capacity());
        capacity.insert(5, "gg");

        System.out.println(capacity);
        System.out.println(capacity.substring(5));

    }

}