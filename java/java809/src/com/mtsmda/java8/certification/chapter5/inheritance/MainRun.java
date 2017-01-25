package com.mtsmda.java8.certification.chapter5.inheritance;

/**
 * Created by dminzat on 7/19/2016.
 */
public class MainRun {

    public static void main(String[] args) {
        Animal animal = new Lion();
        animal.setAge(15);
        System.out.println(animal.getAge());

        Lion lion = new Lion();
        lion.setAge(7);
        System.out.println(lion.getAge());
    }

}