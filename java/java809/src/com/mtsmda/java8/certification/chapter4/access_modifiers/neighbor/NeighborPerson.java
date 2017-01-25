package com.mtsmda.java8.certification.chapter4.access_modifiers.neighbor;

import com.mtsmda.java8.certification.chapter4.access_modifiers.mainpack.Person;

/**
 * Created by dminzat on 7/14/2016.
 */
public class NeighborPerson {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("public - " + person.lastname);

        System.out.println();

        new NeighborPersonChild().print();
    }

}