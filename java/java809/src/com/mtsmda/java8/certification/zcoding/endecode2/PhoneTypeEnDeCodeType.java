package com.mtsmda.java8.certification.zcoding.endecode2;

/**
 * Created by dminzat on 8/5/2016.
 */
public enum PhoneTypeEnDeCodeType {

    BOTH(-1),
    RUS(0),
    ENG(1),
    ONE_BOTH(2);

    private Integer typeInt;

    PhoneTypeEnDeCodeType(Integer typeInt) {
        this.typeInt = typeInt;
    }

    public Integer getTypeInt() {
        return typeInt;
    }
}