package com.mtsmda.book.java8.ch3;

import com.mtsmda.book.java8.other.clone_.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by dminzat on 12/25/2016.
 */
public class MethodReference {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 25, 37)));
        System.out.println("--------------------------------------");
        methodRef();

        System.out.println("***********Reference to a constructor*************");
        List<String> strings = Arrays.asList("192", "92", "101", "753", "7135");
        //java 8
        HashSet<String> transfer = transfer(strings, () -> new HashSet<>());
        System.out.println(strings.size());
        System.out.println(transfer.size());
        //before java 8
        transfer = transfer(strings, HashSet::new);
        System.out.println(strings.size());
        System.out.println(transfer.size());

        System.out.println("***********Reference to a static method*************");
        Converter<Integer, String> stringConverter = Integer::valueOf;
        System.out.println(stringConverter.convert("123469"));

        System.out.println("***********Reference to a instance method*************");
        Something something = new Something();
        Converter<String, String> stringStringConverter = something::startWith;
        System.out.println(stringStringConverter.convert("java"));

        CarGen<Car, String, Integer> carGen = Car::new;
        Car ivanov = carGen.getObject("Ivanov", 1050);
        System.out.println(ivanov.toString());

    }

    private static class Something{
        String startWith(String s){
            return String.valueOf(s.charAt(0));
        }
    }

    private static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transfer(SOURCE sourceCollection, Supplier<DEST> destSupplier) {
        DEST result = destSupplier.get();
        sourceCollection.forEach(cur -> {
            result.add(cur);
        });
        return result;
    }

    private static void methodRef() {
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
    }

    public static class Car {
        private String name;
        private Integer age;

        public Car() {

        }

        public Car(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public static Car create(final Supplier<Car> carSupplier) {
            return carSupplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("collide - " + car);
        }

        public void follow(final Car car) {
            System.out.println("follow - " + car);
        }

        public void repair() {
            System.out.println("repaired - " + this);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

interface CarGen<OBJECT, F, S>{
    OBJECT getObject(F f, S s);
}

interface Converter<T, D> {
    T convert(D d);
}

class DuckHelper {
    public static int compareByWeight(Duck duckFirst, Duck duckSecond) {
        return duckFirst.getWeight() - duckSecond.getWeight();
    }
}

class Duck {
    private String name;
    private Integer weight;

    public Duck() {

    }

    public Duck(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}