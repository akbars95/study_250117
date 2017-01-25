package com.mtsmda.java8.certification.chapter5.multiple_inheritance_interface;

/**
 * Created by dminzat on 7/19/2016.
 */
public class MainRun {

    public static void main(String[] args) {
        Big big = new SizeClass();
        big.size();
        big.name();

        Small small = new SizeClass();
        small.size();
    }

}