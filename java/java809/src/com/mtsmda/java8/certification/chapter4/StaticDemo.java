package com.mtsmda.java8.certification.chapter4;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
/**
 * Created by dminzat on 7/15/2016.
 */
public class StaticDemo {

    public static void main(String[] args) {
        ClassMain.main(new String[]{});
        System.out.println(ClassMain.name);

        ClassMain classMain = new ClassMain();
        System.out.println(classMain.name);
        classMain = null;
        System.out.println(classMain == null);
        System.out.println(classMain.name);

        System.out.println("\nstatic init\n");
        new StaticInitialization();

        System.out.println("static imports");

        List<String> stringList = Arrays.asList("one", "two");
    }

}

class StaticInitialization{

    private static final int NUM_SECONDS_PER_HOUR;

    private static int one;
    private static  final int two;
    private static final int three = 3;
//    private static final int four;
    static {
        one = 1;
        two = 2;
//        three = 3;
//        two = 24;
    }

    static {
        int numSecondsPerMinute = 60;
        int numMinutesPerHour = 60;
        NUM_SECONDS_PER_HOUR = numMinutesPerHour * numSecondsPerMinute;
        System.out.println(NUM_SECONDS_PER_HOUR);
    }

}

class ClassMain {

    public static String name = "Oleg";

    public static void main(String[] args) {
        System.out.println("ClassMain.main()");
    }

}