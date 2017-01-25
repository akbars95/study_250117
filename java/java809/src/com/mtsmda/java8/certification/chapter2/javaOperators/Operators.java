package com.mtsmda.java8.certification.chapter2.javaOperators;

/**
 * Created by dminzat on 7/5/2016.
 */
public class Operators {

    public static void main(String[] args) {
        int y = 4;
        double x = 3 + 2 * --y;
        System.out.println("y - " + y);
        System.out.println("x - " + x);

        System.out.println("-----------------------------------");
        System.out.println("9 / 2 = " + 9 / 2);
        System.out.println("9 % 2 = " + 9 % 2);

        System.out.println(-9 % 4);
        System.out.println(9 % 11);
        System.out.println(1 % 11);
        System.out.println(1 / 11);

        System.out.println("-----------------------------------");

        /*rule#1*/
        int xI = 1;
        long yL = 33;
        long result = xI * yL;

        /*rule#2*/
        float xF = 2.1F;
        double xD = 39.21;
        double vResult = xF * xD;

        /*rule#3*/
        short xS = 10;
        short yS = 20;
        int iResult = xS + yS;

        /*rule#4*/
        short xS1 = 14;
//        float yF1 = 13.;
        float yF1 = 13;
        double zD = 30;
        double vResult1 = xS1 * yF1 / zD;

        System.out.println("-----------------------------------");

        double c = 79;
        System.out.println("c = " + c);
        c = -c;
        System.out.println("c = " + c);
        c = -(-c);
        System.out.println("c = " + c);

        System.out.println("-----------------------------------");
        int x3 = 3;
        int yUndefined = ++x3 * 5 / x3-- + --x3;
        System.out.println("x3 = " + x3);
        System.out.println("yUndefined = " + yUndefined);

        System.out.println("-----------------------------------");
        int max = Integer.MAX_VALUE;
        int maxM = max + max * 2;
        System.out.println(max);
        System.out.println(maxM);

    }

}