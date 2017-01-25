package com.mtsmda.java8.certification.chapter4.access_modifiers.mainpack.child;

import com.mtsmda.java8.certification.chapter4.access_modifiers.mainpack.Person;

/**
 * Created by dminzat on 7/14/2016.
 */
public class ChildPerson extends Person{

    public void print(){
        System.out.println("public - " + this.lastname);
        System.out.println("protected - " + this.firstname);
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("public - " + person.lastname);

    }

}