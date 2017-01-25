package com.mtsmda.java8.certification.zcoding.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 8/5/2016.
 */
public class Helper {

    public static List<Character> getCharacters(String input){
        List<Character> characterList = new ArrayList<>();
        if(!isNotBlankString(input)){
            throw new RuntimeException("Input parameter is null or empty");
        }
        for (int i = 0; i < input.length(); i++){
            characterList.add(new Character(input.charAt(i)));
        }
        return characterList;
    }

    public static<T> boolean isNotBlankString(String inputStr){
        return isNotNullObject(inputStr) && !inputStr.isEmpty();
    }

    public static<T> boolean isNotNullObject(T object){
        return (null != object);
    }

    public static final long generateRandom(long multiplier) {
        long round = -1L;
        String checkBroads = null;
        String stringMultiplier = new Long(multiplier).toString().substring(1);
        do {
            round = Math.round(Math.random() * multiplier);
            checkBroads = new Long(round).toString();
        } while (checkBroads.length() != stringMultiplier.length());
        return round;
    }

    public static final int generateRandomWithBorders(int begin, int end) {
        int returnValue = -1;
        do {
            returnValue = (int) Math.round(Math.random() * end);
        }
        while (!(returnValue >= begin && returnValue <= end));
        return returnValue;
    }

}