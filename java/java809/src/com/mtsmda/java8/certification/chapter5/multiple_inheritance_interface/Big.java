package com.mtsmda.java8.certification.chapter5.multiple_inheritance_interface;

/**
 * Created by dminzat on 7/19/2016.
 */
public interface Big {

    public void size();

    public default void name(){
        System.out.println(this.getClass().isInterface() ? "inteface" : "class" + " _ " + this.getClass().getCanonicalName());
        System.out.println();
    }

}