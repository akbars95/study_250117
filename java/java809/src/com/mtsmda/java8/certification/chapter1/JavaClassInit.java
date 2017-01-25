package com.mtsmda.java8.certification.chapter1;

/**
 * Created by MTSMDA on 27.06.2016.
 */
public class JavaClassInit {

    private String name = "Audi";


    public JavaClassInit() {
        name = "Mercedes";
    }

    {
        name = "Porsche";
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(new JavaClassInit().getName());
    }

}