package com.mtsmda.java8.certification.zcoding;

import com.mtsmda.java8.certification.zcoding.type.EnDecodeType;

import java.util.ArrayList;
import java.util.List;

import static com.mtsmda.java8.certification.zcoding.common.Helper.*;

/**
 * Created by dminzat on 7/21/2016.
 */
public class CodecMTSMDA {

    private static final int RANDOM = 0;
    private static final int TYPE = 1;

    private static final String ESCAPE_DIGITS = "#!$%^";
    private static final int DEFAULT_SHIFT_INT = 19;


    //init piece
    private static List<Character> characters = new ArrayList<>();


    static {
        addChars(33, 126);
        addChars(1040, 1103);
        addChars(1105, 1105);
//        System.out.println(characters.size());
    }

    static List<Character> getCharacters(){
        return characters;
    }

    static StringBuilder getCharactersAsString(){
        StringBuilder result = new StringBuilder();
        characters.forEach(current -> result.append(current));
        return result;
    }

    private static void addChars(int beginIndex, int endIndex) {
        for (int i = beginIndex; i <= endIndex; i++) {
            characters.add(new Character((char) i));
        }
    }

    //encode & decode helper methods
    private static void checkInput(String input) {
        if (null == input || input.isEmpty()) {
            throw new RuntimeException("Input data is null or is empty!");
        }
    }

    private static StringBuilder convertUppercaseToLowerCaseAndViceVersa(String input) {
        return convertUppercaseToLowerCaseAndViceVersa(new StringBuilder(input));
    }

    private static StringBuilder convertUppercaseToLowerCaseAndViceVersa(StringBuilder input) {
        StringBuilder result = new StringBuilder(input);
        for (int i = 0; i < result.length(); i++) {
            Character c = result.charAt(i);
            if (null != c && Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    result.replace(i, i + 1, "" + Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    result.replace(i, i + 1, "" + Character.toUpperCase(c));
                }
            }
        }
        if (result.equals(input)) {
            throw new RuntimeException("Cannot convert upperCase to Lower Case");
        }
        return result;
    }

    //encode piece
    public static StringBuilder encode(String input, EnDecodeType enDecodeType) {
        StringBuilder result = new StringBuilder();
        checkInput(input);
        switch (enDecodeType) {
            case INVERTER: {
                result.append(input).reverse();
            }
            break;
            case CONVERT_U_CASE_TO_L: {
                result = convertUppercaseToLowerCaseAndViceVersa(input);
            }
            break;
            case INVERTER_CONVERT_U_CASE_TO_L: {
                result = convertUppercaseToLowerCaseAndViceVersa(input).reverse();
            }
            break;
            case SHIFT_DEFAULT: {
                result = shiftType(new StringBuilder(input), EnDecodeType.SHIFT_DEFAULT);
            }
            break;
            case SHIFT_RANDOM: {
                result = shiftType(new StringBuilder(input), EnDecodeType.SHIFT_RANDOM);
            }
            break;
            case SHIFT_RANDOM_EACH: {
                result = shiftType(new StringBuilder(input), EnDecodeType.SHIFT_RANDOM_EACH);
            }
            break;
        }
        result.insert(0, enDecodeType.getCode().toString()).append(enDecodeType.getStringCode());
        //add begin 9 random digits and add end 7 random digits
        result.insert(0, generateRandom(1_000_000_000)).append(generateRandom(10_000_000));

        return result;
    }

    //encode helper methods


    private static StringBuilder shiftType(StringBuilder input, EnDecodeType enDecodeType) {
        StringBuilder result = new StringBuilder();
        long lShift = -1;
        switch (enDecodeType) {
            case SHIFT_DEFAULT: {
                lShift = DEFAULT_SHIFT_INT;
                process(input, lShift, result, EnDecodeType.SHIFT_DEFAULT);
            }
            break;
            case SHIFT_RANDOM: {
                lShift = Math.round(Math.random() * 9);
                process(input, lShift, result, EnDecodeType.SHIFT_RANDOM);
                result.insert(0, lShift);
            }
            break;
            case SHIFT_RANDOM_EACH: {
                process(input, lShift, result, EnDecodeType.SHIFT_RANDOM_EACH);
            }
            break;
        }
        return result;
    }

    private static void process(StringBuilder input, long lShift, StringBuilder result, EnDecodeType enDecodeType) {
        boolean isDigit = false;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int currentCharIndex = characters.indexOf(currentChar);
            int newIndex = -1;
            int eachRandom = -1;
            switch (enDecodeType) {
                case SHIFT_RANDOM_EACH: {
                    eachRandom = generateRandomWithBorders(1, 9);
                    newIndex = currentCharIndex + eachRandom;
                }
                break;
                case SHIFT_DEFAULT:
                case SHIFT_RANDOM: {
                    newIndex = currentCharIndex + (int) lShift;
                    if (Character.isDigit(currentChar)) {
//                        newIndex += (int) currentChar;
//                        newIndex *= lShift;
                        isDigit = true;
                    } else {
                        isDigit = false;
                    }

                }
                break;
            }
            if (eachRandom != -1) {
                if (newIndex >= 0 && newIndex <= 9) {
                    result.append(characters.get(0)).append(characters.get(0)).append(characters.get(0));
                } else if (newIndex >= 10 && newIndex <= 99) {
                    result.append(characters.get(0)).append(characters.get(0));
                } else if (newIndex >= 100 && newIndex <= 999) {
                    result.append(characters.get(0));
                }
                result.append(newIndex).append(eachRandom);
            } else if (newIndex >= characters.size()) {//160 > 158
                result.append(newIndex * 10);//newIndex *= 10;
            } else {
                if (isDigit) {
                    result.append(ESCAPE_DIGITS);
                }
                result.append(characters.get(newIndex));
            }
        }
    }

    //decode piece
    public static StringBuilder decode(String input) {
        return decode(new StringBuilder(input));
    }

    public static StringBuilder decode(StringBuilder input) {
        checkInput(input.toString());
        StringBuilder result = new StringBuilder();

        cutStartAndEndInfo(input, null, RANDOM);
        EnDecodeType enDecodeType = defineDecodeType(input);
        cutStartAndEndInfo(input, enDecodeType, TYPE);

        switch (enDecodeType) {
            case INVERTER: {
                result = input.reverse();
            }
            break;
            case CONVERT_U_CASE_TO_L: {
                result = convertUppercaseToLowerCaseAndViceVersa(input);
            }
            break;
            case INVERTER_CONVERT_U_CASE_TO_L: {
                result = convertUppercaseToLowerCaseAndViceVersa(input).reverse();
            }
            break;
            case SHIFT_DEFAULT: {
                result = shiftTypeDecode(new StringBuilder(input), EnDecodeType.SHIFT_DEFAULT);
            }
            break;
            case SHIFT_RANDOM: {
                result = shiftTypeDecode(new StringBuilder(input), EnDecodeType.SHIFT_RANDOM);
            }
            break;
            case SHIFT_RANDOM_EACH: {
                result = shiftTypeDecode(new StringBuilder(input), EnDecodeType.SHIFT_RANDOM_EACH);
            }
            break;
        }

        return result;
    }

    //decode helper methods
    private static StringBuilder shiftTypeDecode(StringBuilder input, EnDecodeType enDecodeType) {
        StringBuilder result = new StringBuilder();
        int lShift = -1;
        switch (enDecodeType) {
            case SHIFT_DEFAULT: {
                lShift = DEFAULT_SHIFT_INT;
                processDecodeShift(input, result, lShift);
            }
            break;
            case SHIFT_RANDOM: {
                Character randomChar = input.charAt(0);
                if (Character.isDigit(randomChar)) {
                    Integer randomInteger = Character.getNumericValue(randomChar);
                    if (randomInteger != null) {
                        lShift = randomInteger;
                        input.deleteCharAt(0);
                    }
                }
                processDecodeShift(input, result, lShift);
            }
            break;
            case SHIFT_RANDOM_EACH: {
                processDecodeShift(input, result, lShift);
            }
            break;
        }
        return result;
    }

    private static final void processDecodeShift(StringBuilder input, StringBuilder result, int lShift) {
        boolean isDigitED = false;
        for (int i = 0; i < input.length(); ) {
            if (input.toString().startsWith(ESCAPE_DIGITS)) {
                input.delete(0, ESCAPE_DIGITS.length());
                isDigitED = true;
            } else {
                isDigitED = false;
            }
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                int currentCharIndex = characters.indexOf(currentChar);
                if (currentCharIndex != -1) {
                    result.append(characters.get(currentCharIndex - lShift));
                    if (isDigitED) {
                        input.delete(0, 1);
                    }else{
                        i++;
                    }
                }
            } else if (Character.isDigit(currentChar)) {
                String substring = input.substring(i, i + 4);
                boolean isDigit = true;
                for (int j = 0; j < substring.length(); j++) {
                    if (!Character.isDigit(substring.charAt(j))) {
                        isDigit = false;
                        break;
                    }
                }
                if (isDigit) {
                    int currentIndex = Integer.parseInt(substring);
                    if (currentIndex % 10 == 0) {
                        currentIndex /= 10;
                        currentIndex -= lShift;
                        result.append(characters.get(currentIndex));
                        i += 4;
                    } else {
                        throw new RuntimeException("Last accept index is - " + (characters.size() - 1) + ", but current index is - " + (currentIndex / 10) + " - substring - " + substring);
                    }
                }
            } else {
                int currentCharIndex = characters.indexOf(currentChar);
                if (currentChar == characters.get(0) && currentCharIndex == 0) {
                    String indexStr = cutExclamationMark(input.substring(i, i + 5));
                    String randomValueStr = indexStr.charAt(indexStr.length() - 1) + ""; //cutExclamationMark(input.substring(i + 4, i + 5));
                    int index = Integer.parseInt(indexStr.substring(0, indexStr.length() - 1));
                    int randomValue = Integer.parseInt(randomValueStr);
                    index -= randomValue;
                    result.append(characters.get(index));
                    i += 5;
                } else if (currentCharIndex != -1) {
                    result.append(characters.get(currentCharIndex - lShift));
                    i++;
                }
            }
        }
    }

    private static final String cutExclamationMark(String input) {
        String result = null;
        if (null != input) {
            result = "";
            for (int i = 0; i < input.length(); i++) {
                if (characters.get(0) != input.charAt(i)) {
                    result += input.charAt(i);
                }
            }
        }
        return result;
    }

    private static void cutStartAndEndInfo(StringBuilder input, EnDecodeType enDecodeType, int cutType) {
        if (RANDOM == cutType) {
            input.delete(0, 9);
            input.delete(input.length() - 7, input.length());
        } else if (TYPE == cutType) {
            input.delete(0, enDecodeType.getCode().toString().length());
            input.delete(input.length() - enDecodeType.getStringCode().length(), input.length());
        }
    }

    private static EnDecodeType defineDecodeType(StringBuilder input) {
        for (EnDecodeType currentEnDecodeType : EnDecodeType.values()) {
            if (input.toString().startsWith(currentEnDecodeType.getCode().toString()) &&
                    input.toString().endsWith(currentEnDecodeType.getStringCode())) {
                return currentEnDecodeType;
            }
        }
        throw new RuntimeException("Cannot define decode type!");
    }
}