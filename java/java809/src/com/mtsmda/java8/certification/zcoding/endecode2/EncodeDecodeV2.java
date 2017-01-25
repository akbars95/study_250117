package com.mtsmda.java8.certification.zcoding.endecode2;

import com.mtsmda.java8.certification.zcoding.common.Helper;
import com.mtsmda.java8.certification.zcoding.type.EnDecodeType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.java8.certification.zcoding.endecode2.PhoneTypeEnDeCode.*;

/**
 * Created by dminzat on 8/5/2016.
 */
public class EncodeDecodeV2 {

    private StringBuilder result = new StringBuilder();

    private static final String ESCAPE_DIGITS = "#!$%^";
    private static final String ESCAPE_CHARACTER = "/.,;:";

    public StringBuilder encode(String input, EnDecodeType enDecodeType){
        return encode(new StringBuilder(input), enDecodeType);
    }

    public StringBuilder encode(StringBuilder input, EnDecodeType enDecodeType){
        if(!Helper.isNotBlankString(input.toString())){
            throw new RuntimeException("Input value is null or empty");
        }
        if(!result.toString().isEmpty()){
            result.delete(0, result.length());
        }
        switch (enDecodeType){
            case PHONE_KEYBOARD:{
                init(PhoneTypeEnDeCodeType.BOTH);
            }break;
        }

        return result;
    }

    private void phoneKeywordEncode(StringBuilder input){
        for(int i = 0; i < input.toString().length(); i++){
            char currentChar = input.charAt(i);
            if(Character.isDigit(currentChar)){
                result.append(ESCAPE_DIGITS);

            }else if (Character.isLetter(currentChar)){
                result.append(ESCAPE_CHARACTER);

            }else{
                result.append(currentChar);
            }
        }
    }

}