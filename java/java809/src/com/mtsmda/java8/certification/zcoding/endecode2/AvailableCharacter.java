package com.mtsmda.java8.certification.zcoding.endecode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 8/5/2016.
 */
public class AvailableCharacter {

    //init static
    private static List<Character> characters = new ArrayList<>();


    static {
        addChars(33, 126);
        addChars(1040, 1103);
        addChars(1105, 1105);
//        System.out.println(characters.size());
    }

    public static List<Character> getCharacters(){
        return characters;
    }

    public static StringBuilder getCharactersAsString(){
        StringBuilder result = new StringBuilder();
        characters.forEach(current -> result.append(current));
        return result;
    }

    private static void addChars(int beginIndex, int endIndex) {
        for (int i = beginIndex; i <= endIndex; i++) {
            characters.add(new Character((char) i));
        }
    }

}