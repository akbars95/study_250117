package com.mtsmda.java8.certification.tests;

/**
 * Created by dminzat on 7/12/2016.
 */
public class TestString {

    public static void main(String[] args) {
        HelloWorder helloWorder = new HelloWorder("Ivan");
        HelloWorder helloWorder1 = new HelloWorder("Ivan");
        System.out.println(helloWorder.getName().equals(helloWorder1.getName()));
    }

}

class HelloWorder{
    private String name;

    public HelloWorder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}