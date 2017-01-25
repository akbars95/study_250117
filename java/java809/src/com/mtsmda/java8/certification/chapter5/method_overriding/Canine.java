package com.mtsmda.java8.certification.chapter5.method_overriding;

/**
 * Created by dminzat on 7/20/2016.
 */
public class Canine {

    public double getAverageWeight(){
        return 50;
    }

}

class Wolf extends Canine{

    @Override
    public double getAverageWeight() {
        //return /*super.*/getAverageWeight() + 20;// super comment - StackOverflowError
        return super.getAverageWeight() + 20;
    }

    public static void main(String[] args) {
        System.out.println(new Canine().getAverageWeight());
        System.out.println(new Wolf().getAverageWeight());
    }

}