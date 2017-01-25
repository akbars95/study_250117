package com.mtsmda.java8.certification.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 7/8/2016.
 */
public class TestList {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(21);
        integers.add(13);
        integers.add(30);
        integers.add(11);
        integers.add(2);
        System.out.println(integers);

        integers.removeIf(e -> e % 2 == 0);
        System.out.println(integers);
    }

}