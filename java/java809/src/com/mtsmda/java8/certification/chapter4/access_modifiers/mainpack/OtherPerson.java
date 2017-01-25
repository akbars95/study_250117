package com.mtsmda.java8.certification.chapter4.access_modifiers.mainpack;

/**
 * Created by dminzat on 7/14/2016.
 */
public class OtherPerson {

    public void print(){
        Person person = new Person();
        System.out.println("public - " + person.lastname);
        System.out.println("protected - " + person.firstname);
        System.out.println("default - " + person.age);
    }

}