package com.mtsmda.java8.certification.zcoding.test;

import com.mtsmda.java8.certification.zcoding.type.EnDecodeType;
import com.mtsmda.java8.certification.zcoding.endecode2.EncodeDecodeV2;

/**
 * Created by dminzat on 8/5/2016.
 */
public class EncodeDecodeV2Test {

    public static void main(String[] args) {
        experiments();
        System.out.println("_____________________________");
        EncodeDecodeV2 encodeDecodeV2 = new EncodeDecodeV2();
//        StringBuilder result = encodeDecodeV2.encode(encodeDecodeV2.getCharactersAsString(), EnDecodeType.PHONE_KEYBOARD);
//        System.out.println(result);
    }

    private static void experiments(){
        System.out.println(Character.isLetter('c'));
        System.out.println(Character.isLetter('д'));
        System.out.println(Character.isLetter('#'));
        System.out.println(Character.isLetter('5'));
    }

}