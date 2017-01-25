package com.mtsmda.mockito.application;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created by dminzat on 12/26/2016.
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MathApplicationTest.class);
        result.getFailures().stream().forEach(System.out::println);
        System.out.println(result.wasSuccessful());
    }

}