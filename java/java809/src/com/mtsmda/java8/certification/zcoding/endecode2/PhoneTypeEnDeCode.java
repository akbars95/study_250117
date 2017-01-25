package com.mtsmda.java8.certification.zcoding.endecode2;

import com.mtsmda.java8.certification.zcoding.common.CollectionHelper;
import com.mtsmda.java8.certification.zcoding.common.Helper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.java8.certification.zcoding.common.CollectionHelper.*;

/**
 * Created by dminzat on 8/5/2016.
 */
public class PhoneTypeEnDeCode {

    private static Map<Integer, List<Character>> phoneIntEng = new LinkedHashMap<>();
    private static Map<Integer, List<Character>> phoneIntRus = new LinkedHashMap<>();
    private static Map<Integer, List<Character>> phoneIntBoth = new LinkedHashMap<>();

    public static final String DELIMETER = "{[|]}";

    public static void init(PhoneTypeEnDeCodeType phoneTypeEnDeCodeType) {
        switch (phoneTypeEnDeCodeType) {
            case RUS: {
                fillPhoneInts(PhoneTypeEnDeCodeType.RUS);
            }
            break;
            case ENG: {
                fillPhoneInts(PhoneTypeEnDeCodeType.ENG);
            }
            break;
            case ONE_BOTH: {
                fillPhoneInts(PhoneTypeEnDeCodeType.ONE_BOTH);
            }
            break;
            case BOTH:
            default: {
                init(PhoneTypeEnDeCodeType.ENG);
                init(PhoneTypeEnDeCodeType.RUS);
            }
        }
    }

    private static void fillPhoneInts(PhoneTypeEnDeCodeType phoneTypeEnDeCodeType) {
        if (phoneTypeEnDeCodeType == PhoneTypeEnDeCodeType.RUS) {
            if (phoneIntRus.isEmpty()) {
                phoneIntRus.put(2, Helper.getCharacters("абвг"));
                phoneIntRus.put(3, Helper.getCharacters("деёжз"));
                phoneIntRus.put(4, Helper.getCharacters("ийкл"));
                phoneIntRus.put(5, Helper.getCharacters("мноп"));
                phoneIntRus.put(6, Helper.getCharacters("рсту"));
                phoneIntRus.put(7, Helper.getCharacters("фхцч"));
                phoneIntRus.put(8, Helper.getCharacters("шщъы"));
                phoneIntRus.put(9, Helper.getCharacters("ьэюя"));
            }
        } else if (phoneTypeEnDeCodeType == PhoneTypeEnDeCodeType.ENG) {
            if (phoneIntEng.isEmpty()) {
                phoneIntEng.put(2, Helper.getCharacters("abc"));
                phoneIntEng.put(3, Helper.getCharacters("def"));
                phoneIntEng.put(4, Helper.getCharacters("ghi"));
                phoneIntEng.put(5, Helper.getCharacters("jkl"));
                phoneIntEng.put(6, Helper.getCharacters("mno"));
                phoneIntEng.put(7, Helper.getCharacters("pqrs"));
                phoneIntEng.put(8, Helper.getCharacters("tuv"));
                phoneIntEng.put(9, Helper.getCharacters("wxyz"));
            }
        } else if (phoneTypeEnDeCodeType == PhoneTypeEnDeCodeType.ONE_BOTH) {
            if (phoneIntEng.isEmpty()) {
                fillPhoneInts(PhoneTypeEnDeCodeType.ENG);
                fillPhoneInts(PhoneTypeEnDeCodeType.RUS);
                phoneIntBoth.put(2, joinLists(phoneIntEng.get(2), phoneIntRus.get(2)));
                phoneIntBoth.put(3, joinLists(phoneIntEng.get(3), phoneIntRus.get(3)));
                phoneIntBoth.put(4, joinLists(phoneIntEng.get(4), phoneIntRus.get(4)));
                phoneIntBoth.put(5, joinLists(phoneIntEng.get(5), phoneIntRus.get(5)));
                phoneIntBoth.put(6, joinLists(phoneIntEng.get(6), phoneIntRus.get(6)));
                phoneIntBoth.put(7, joinLists(phoneIntEng.get(7), phoneIntRus.get(7)));
                phoneIntBoth.put(8, joinLists(phoneIntEng.get(8), phoneIntRus.get(8)));
                phoneIntBoth.put(9, joinLists(phoneIntEng.get(9), phoneIntRus.get(9)));
                phoneIntRus.clear();
                phoneIntEng.clear();
            }
        } else {
            throw new RuntimeException("Should be: for rus - " + PhoneTypeEnDeCodeType.RUS.name() + " or eng - " + PhoneTypeEnDeCodeType.ENG.name());
        }
    }

    public static Map<Integer, List<Character>> getPhoneIntEng() {
        if (!Helper.isNotNullObject(phoneIntEng)) {
            fillPhoneInts(PhoneTypeEnDeCodeType.ENG);
        }
        return phoneIntEng;
    }

    public static Map<Integer, List<Character>> getPhoneIntRus() {
        if (!Helper.isNotNullObject(phoneIntRus)) {
            fillPhoneInts(PhoneTypeEnDeCodeType.RUS);
        }
        return phoneIntRus;
    }

    public static Map<Integer, List<Character>> getPhoneIntBoth() {
        if (!Helper.isNotNullObject(phoneIntBoth)) {
            fillPhoneInts(PhoneTypeEnDeCodeType.ONE_BOTH);
        }
        return phoneIntBoth;
    }

    public static String getNumberWithPosition(Character character, PhoneTypeEnDeCodeType phoneTypeEnDeCodeType) {
        StringBuilder result = new StringBuilder();
        switch (phoneTypeEnDeCodeType) {
            case ENG: {

            }
            break;
        }
        return result.toString();
    }

    private static void search(Character character, StringBuilder result, Map<Integer, List<Character>> phoneIntListMap){
        phoneIntListMap.forEach((integerInput, characterInput) -> {
//            if(character.equals(characters))
        });
    }

}