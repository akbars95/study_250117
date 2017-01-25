package com.mtsmda.java8.certification.chapter5.class_access_modifier;

/**
 * Created by dminzat on 7/20/2016.
 */
class Automobile extends Car {

    private String name = "Automobile";

    public /*final*/ void getName() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new Automobile().getName();
    }

}

class Car extends Object{

    private String name = "Car";

    public /*final*/ void getName() {
        System.out.println(this.name);
    }

}