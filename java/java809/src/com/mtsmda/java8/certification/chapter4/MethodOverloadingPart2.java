package com.mtsmda.java8.certification.chapter4;

/**
 * Created by dminzat on 7/18/2016.
 */
public class MethodOverloadingPart2 {

    public static void main(String[] args) {
        System.out.println(glide("a"));
        System.out.println(glide("a", "b"));
        System.out.println(glide("a", "b", "c"));
        System.out.println("\n");

        testInt(1);
        testInt(1, 2);

        testInt(new Integer(18));
        testInt(new Integer(18), new Integer(97));
    }

    private static void testInt(int i){
        System.out.println("testInt(int i)");
    }

    private static void testInt(Integer i){
        System.out.println("testInt(Integer i)");
    }

    private static void testInt(int ... i){
        System.out.println("testInt(int ... i)");
    }

    /*private static void testInt(Integer ... i){
        System.out.println("testInt(Integer ... i)");
    }*/


    public static String glide(String s){
        System.out.println("glide(String s)");
        return "1";
    }

    public static String glide(String ... s){
        System.out.println("glide(String ... s)");
        return "2";
    }

    public static String glide(Object o){
        System.out.println("glide(Object o)");
        return "3";
    }

    public static String glide(String one, String two){
        System.out.println("glide(String one, String two)");
        return "4";
    }


}