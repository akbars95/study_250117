package com.mtsmda.book.java8.other.javareflection;

/**
 * Created by dminzat on 1/10/2017.
 */
public class JavaRefDemo {

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Package aPackage = stringClass.getPackage();
        System.out.println(aPackage.getName());
    }

}