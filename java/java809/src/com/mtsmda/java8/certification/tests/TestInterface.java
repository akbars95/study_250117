package com.mtsmda.java8.certification.tests;

/**
 * Created by dminzat on 7/13/2016.
 */
public class TestInterface {

    public static void main(String[] args) {
        IInterface iInterface = (e) ->{
            System.out.println(e.toString() + " hello");
        };
        iInterface.print("IONel");
        iInterface.toString();
    }

}

interface IInterface{
    void print(Object object);
}