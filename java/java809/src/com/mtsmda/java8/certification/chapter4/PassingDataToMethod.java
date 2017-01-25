package com.mtsmda.java8.certification.chapter4;

/**
 * Created by dminzat on 7/15/2016.
 */
public class PassingDataToMethod {

    public static void main(String[] args) {
        String name = "Barcelona";
        speak(name);
        System.out.println(name);
        System.out.println("*************");
        StringBuilder stringBuilder = new StringBuilder(name);
        System.out.println(stringBuilder);
        speak(stringBuilder);
        System.out.println(stringBuilder);

        System.out.println("*************");

        int number = 1;
        String letters = "abc";
        number(number);//1
        letters(letters);
        System.out.println(letters);
        letters = letters(letters);//abcd
        System.out.println(number + " - " + letters);

    }

    private static int number(int number){
        number++;
        return number;
    }

    private static String letters(String letters){
        letters += "d";
        return letters;
    }

    public static void speak(String name){
        name = "Celtic";
    }

    public static void speak(StringBuilder stringBuilder){
        stringBuilder.append("Milan");
    }

}