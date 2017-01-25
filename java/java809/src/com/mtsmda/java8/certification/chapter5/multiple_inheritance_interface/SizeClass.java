package com.mtsmda.java8.certification.chapter5.multiple_inheritance_interface;

/**
 * Created by dminzat on 7/19/2016.
 */
public class SizeClass implements Big, Small{

    @Override
    public void size() {
        System.out.println(this.getClass().getCanonicalName());
    }
}