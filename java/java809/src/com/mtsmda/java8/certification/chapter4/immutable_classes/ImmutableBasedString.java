package com.mtsmda.java8.certification.chapter4.immutable_classes;

/**
 * Created by dminzat on 7/19/2016.
 */
public class ImmutableBasedString {

    private String name;

    public ImmutableBasedString(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        ImmutableBasedString immutableBasedString = new ImmutableBasedString("String");
        System.out.println(immutableBasedString.getName());

        System.out.println("------------------------");

        StringBuilder text = new StringBuilder("Barcelona");
        MutableBasedStringBuilder mutableBasedStringBuilder = new MutableBasedStringBuilder(text);
        mutableBasedStringBuilder.getText().append(" Milan");
        System.out.println(text);
        System.out.println(mutableBasedStringBuilder.getText());
    }

}

class MutableBasedStringBuilder{

    private StringBuilder text;

    public MutableBasedStringBuilder(StringBuilder text) {
        this.text = text;
    }

    public StringBuilder getText() {
        return text;
    }

}

class ImmutableBasedStringBuilderM1 {

    private StringBuilder text;

    public ImmutableBasedStringBuilderM1(StringBuilder text) {
        this.text = text;
    }

    public StringBuilder getText() {
        return new StringBuilder(text);
    }

}

class ImmutableBasedStringBuilderM2 {

    private StringBuilder text;

    public ImmutableBasedStringBuilderM2(StringBuilder text) {
        this.text = text;
    }

    public String getText() {
        return text.toString();
    }

}