package com.mtsmda.reflection;

import com.mtsmda.reflection.model.Car;
import com.mtsmda.reflection.model.Person;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 2/2/2017.
 */
public class Run {

    private static final List<Class> CLASSES = new ArrayList<>();

    static {
        CLASSES.add(String.class);
        CLASSES.add(Integer.class);
        CLASSES.add(Short.class);
        CLASSES.add(Double.class);
        CLASSES.add(Float.class);
        CLASSES.add(Byte.class);
        CLASSES.add(Boolean.class);
    }

    public static void main(String[] args) {
        Car car = new Car(19034, "Audi", "Q7", LocalDate.of(1999, 10, 01));
        Person person = new Person(130, "Ivanov", "Ivan", "Ivanovici", LocalDate.of(1980, 9, 17), new Character('m'), car, "069-861-731");
        reflect(person);
    }

    private static <T> void reflect(T tObject) {
        Method[] declaredMethods = tObject.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.getName().startsWith("get")) {
                if(!isAssignableFrom(CLASSES, method.getReturnType())){
                    System.out.println(method.getName() + " - " + method.getReturnType());
                }
            }
        }
    }

    private static boolean isAssignableFrom(List<Class> classes, Class aClassIn){
        boolean retVal = true;
        for(Class aClass : classes){
            retVal = aClassIn.isAssignableFrom(aClass);
            if(!retVal){
                return retVal;
            }
        }
        return retVal;
    }

}