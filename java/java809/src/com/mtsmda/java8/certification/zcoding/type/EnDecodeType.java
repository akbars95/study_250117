package com.mtsmda.java8.certification.zcoding.type;

/**
 * Created by dminzat on 7/21/2016.
 */
public enum EnDecodeType {

    /**
    * reverse text - thisIsPassword = drowssaPsIsiht
    * */
    INVERTER(159, "I159i"),
    /**
     * convert upper case to lower case and vice versa - thisIsPassword = THISiSpASSWORDU
     * */
    CONVERT_U_CASE_TO_L(953, "U953l"),
    /**
     * union {@link EnDecodeType.INVERTER} and {@link EnDecodeType.CONVERT_U_CASE_TO_L}
     * */
    INVERTER_CONVERT_U_CASE_TO_L(753, "IU753l"),
    /**
     * default shift
     * */
    SHIFT_DEFAULT(620, "S620D"),
    /**
     * random shift
     * */
    SHIFT_RANDOM(753, "S753R"),
    /**
     * random shift each symbol
     * */
    SHIFT_RANDOM_EACH(123, "S123RE"),
    /**
     * random shift each symbol
     * */
    PHONE_KEYBOARD(123, "p325K");

    /**
     * begin
     * */
    private Integer code;

    /**
     * end
     * */
    private String stringCode;
/*
    EnDecodeType() {

    }

    EnDecodeType(Integer code) {
        this.code = code;
    }*/

    EnDecodeType(Integer code, String stringCode) {
        this.code = code;
        this.stringCode = stringCode;
    }

    public Integer getCode() {
        return code;
    }

    public String getStringCode() {
        return stringCode;
    }
}