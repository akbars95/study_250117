package com.mtsmda.java8.certification.chapter4.lambdaEx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 7/19/2016.
 */
public class DemoLambdaArrayList {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 1_000; i++){
            integers.add(new Double(Math.random() * 5 * (i + 31)).intValue());
        }

        System.out.println("size before - " + integers.size());
        integers.removeIf(integer -> integer > 50 && integer % 2 == 0);
        System.out.println("size after - " + integers.size());
    }

}