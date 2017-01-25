package com.mtsmda.java8.certification.chapter2.javaStatements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dminzat on 7/7/2016.
 */
public class ForEachSt {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        for(int value : integers){
            System.out.println(value + ", ");
        }

        for (Iterator<Integer> i = integers.iterator(); i.hasNext();){
            System.out.println(i.next() + ", ");
        }
    }

}