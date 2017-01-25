package com.mtsmda.java8.certification.chapter4.constructorEx;

/**
 * Created by dminzat on 7/18/2016.
 */
public class FinalFieldInit {

    private final int volume;
    private final String lastname;
    private static final String firstname;
    private final String name = "The mouse house";

    {
        lastname = "";
//        firstname = "";
    }

    static {
        firstname = "";
    }

    public FinalFieldInit(int length, int width, int height) {
        volume = length * width * height;
//        firstname = "";
    }
}