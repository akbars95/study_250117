package com.mtsmda.java8.certification.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 7/13/2016.
 */
public class AutoboxingDemo {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        System.out.println(integers);

        integers.remove(1);
        System.out.println(integers);
    }

}