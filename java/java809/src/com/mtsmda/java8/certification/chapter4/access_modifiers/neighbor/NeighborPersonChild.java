package com.mtsmda.java8.certification.chapter4.access_modifiers.neighbor;

import com.mtsmda.java8.certification.chapter4.access_modifiers.mainpack.Person;

/**
 * Created by dminzat on 7/14/2016.
 */
public class NeighborPersonChild extends Person {

    public void print(){
        System.out.println("protected - " + this.firstname);
        System.out.println("public - " + this.lastname);
    }

}