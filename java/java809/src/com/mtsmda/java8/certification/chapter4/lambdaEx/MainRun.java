package com.mtsmda.java8.certification.chapter4.lambdaEx;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by dminzat on 7/19/2016.
 */
public class MainRun {

    private static int count = 0;

    private boolean isClass;

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        System.out.println("before java 8\n*****");
        print(animals, new CheckAnimalFeatureHopperImpl());

        System.out.println("java 8\n*****");
        print(animals, a ->  true);

        print(animals, a ->  a.isCanSwim());

        print(animals, a ->  !a.isCanSwim());

        print(animals, (Animal a) ->  {return a.isCanSwim();});

        print(() -> System.out.println(++count));//0 parammeters

        OneParam oneParam = text -> {
            System.out.println("Hello, " +
                    ((text != null && !text.isEmpty()) ? text : "anonim") + "!");
        };

        oneParam.test("Ivanov");

        OneParam oneParamV2 = (String text) -> System.out.println(text);
        oneParamV2.test("simple test");

        TwoParam twoParam = (id, firstname) -> {
            Map<Integer, String> userMap = new LinkedHashMap<>();
            userMap.put(10, "Messi");
            userMap.put(7, "C.Ronaldo");
            userMap.put(9, "Higuain");
            userMap.put(22, "Kaka");
            userMap.put(10, "Arshavin");

            boolean is = false;

            exit:
            for (Integer currentId : userMap.keySet()){
                if(currentId.equals(id)){
                    String currentFirstname = userMap.get(currentId);
                    if(currentFirstname.equals(firstname)){
                        System.out.println("This person " + firstname + " has in our system!");
                        is = true;
                        break exit;
                    }
                }
            }

            if(!is){
                System.out.println("ERROR!\t" + firstname + " has not in our SYSTEM!");
            }
        };

        twoParam.getUserByIdAndFirstname(15, "Titov");
        twoParam.getUserByIdAndFirstname(22, "Kaka");

        boolean flag = true;

        Predicate<String> stringPredicate = text -> text.length() > 25 && flag;
        System.out.println(stringPredicate.test("Ivanovskii"));

        Predicate<Double> doublePredicate;
        doublePredicate = price ->{
            System.out.println("before - " + price);
            if(flag){
                price *= 10;
//                flag = false;
            }
            System.out.println("count is - " + ++count);
            MainRun mainRun = new MainRun();
            mainRun.isClass = true;
            System.out.println(mainRun.isClass);
            System.out.println("after - " + price);
            return price > 1_000;
        };

        System.out.println(doublePredicate.test(79.));

        Consumer<String> stringConsumer = s -> {
//            String s = "blablabla";
            s += "_blablabla";
            System.out.println(s);
        };

        stringConsumer.accept("Consumer String");

        //predicate interface
        System.out.println();

        Predicate<Animal> animalPredicate = animal -> {
            return !animal.isCanSwim();
        };

        for (Animal animal : animals){
            if(animalPredicate.test(animal)){
                System.out.println(animal.getSpecies() + " cannot swim");
            }
        }

    }


    private static void print(NullParam nullParam){
        nullParam.test();
    }

    private static void print(List<Animal> animals, CheckAnimalFeature checkAnimalFeature){
        for(Animal animal : animals){
            if(checkAnimalFeature.test(animal)){
                System.out.println(animal.getSpecies());
            }
        }
        System.out.println("__________________________");
    }

}