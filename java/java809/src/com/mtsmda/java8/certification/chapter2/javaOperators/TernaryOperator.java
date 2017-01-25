package com.mtsmda.java8.certification.chapter2.javaOperators;

import java.util.Date;

/**
 * Created by dminzat on 7/6/2016.
 */
public class TernaryOperator {

    public final int finalInt;

    {
        finalInt = 9;
    }

    public TernaryOperator() {
//        finalInt = 10;
    }

    public static void main(String[] args) {
        int y = 10;
        final int x;
        if (y > 5) {
            x = 2 * y;
        } else {
            x = 3 * y;
        }
        System.out.println(x);


        int x2 = (y > 5) ? (2 * y) : (3 * y);
        System.out.println(x2);

        System.out.println((y > 11) ? 2 : "Yes");
        Object o = (y < 5) ? "H" : new Date();
        System.out.println(o);


        System.out.println("=====================");
        ternaryExp();
    }

    private static final void ternaryExp() {
        int y = 1;
        int z = 1;
        final int x = y < 10 ? y++ : z++;
        System.out.println("y = " + y);
        System.out.println("z = " + z);

        {
            y = 5;
            z = 5;
            System.out.println("y = " + y);
            int g = (y >= 6) ? ++y : z--;
            System.out.println("y = " + y);
        }

        String s = (3 > 2) ? (1 < -1) ? "(1 < -1)": "" : "";
        System.out.println(s);

        {
            int g = 15;
            System.out.println(g);
        }
    }

}