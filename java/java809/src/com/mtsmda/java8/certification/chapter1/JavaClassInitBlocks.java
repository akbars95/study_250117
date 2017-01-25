package com.mtsmda.java8.certification.chapter1;

/**
 * Created by MTSMDA on 27.06.2016.
 */
public class JavaClassInitBlocks {

    {
//        System.out.println(number);
        System.out.println("block#1");
    }

    private int number;


    {
        System.out.println("block#2");
    }

    public JavaClassInitBlocks() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        new JavaClassInitBlocks();
    }

}