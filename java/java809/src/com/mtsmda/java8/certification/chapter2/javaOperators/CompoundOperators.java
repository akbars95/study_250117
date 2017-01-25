package com.mtsmda.java8.certification.chapter2.javaOperators;

/**
 * Created by dminzat on 7/6/2016.
 */
public class CompoundOperators {

    public static void main(String[] args) {
        long x = 10;
        int y = 5;
//        y = y * x;
        y *= x;

        short s = 10;
        int c = 15;
        s += c;
//        s = s + c;
        System.out.println(s);
    }

}