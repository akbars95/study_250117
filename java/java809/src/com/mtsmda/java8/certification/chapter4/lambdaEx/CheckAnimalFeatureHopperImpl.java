package com.mtsmda.java8.certification.chapter4.lambdaEx;

/**
 * Created by dminzat on 7/19/2016.
 */
public class CheckAnimalFeatureHopperImpl implements CheckAnimalFeature{

    @Override
    public boolean test(Animal a) {
        return a.isCanHop();
    }
}