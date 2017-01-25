package com.mtsmda.java8.certification.chapter4;

/**
 * Created by MTSMDA on 17.07.2016.
 */
public class MethodOverloading {

    public static void main(String[] args) {
        new MethodOverloading().fly(5);
        new MethodOverloading().fly((short) 5);

        new MethodOverloading().make(1);
        new MethodOverloading().make(new Integer(19));
        new MethodOverloading().make(new Integer(19).intValue());
        new MethodOverloading().make(1, 2);
        new MethodOverloading().make(new int[]{});

        System.out.println("Reference types");
        new MethodOverloading().makeDo("Jeep");
        new MethodOverloading().makeDo(19);
        new MethodOverloading().makeDo(null);
        String s = null;
        new MethodOverloading().makeDo(s);
        Object o = null;
        new MethodOverloading().makeDo(o);
        StaticDemo staticDemo = null;
        new MethodOverloading().makeDo(staticDemo);

        new MethodOverloading().makeDo(15);
        new MethodOverloading().makeDo(15L);


    }

    public void makeDo(int i){
        System.out.println("public void makeDo(int i)");
    }

    public void makeDo(long l){
        System.out.println("public void makeDo(long l)");
    }

    public void makeDo(Object object){
        System.out.println("public void makeDo(Object object)");
    }

    public void makeDo(String text){
        System.out.println("public void makeDo(String text)");
    }

    /*public void makeDo(Number number){
        System.out.println("public void makeDo(Number number)");
    }*/

    /*public void makeDo(Double aDouble){
        System.out.println("public void makeDo(Double aDouble)");
    }

    public void makeDo(Integer integer){
        System.out.println("public void makeDo(Integer integer)");
    }*/

    public void make(Integer numbers){
        System.out.println("public void make(Integer numbers)");
    }

    public void make(int numbers){
        System.out.println("public void make(int numbers)");
    }

    public void make(int ... numbers){
        System.out.println("public void make(int ... numbers)");
    }

    public void fly(int [] numbers){
        System.out.println("public void fly(int [] numbers)");
    }

    /*public void fly(int ... numbers){
        System.out.println("public void fly(int ... numbers)");
    }*/

    public void fly(int numbers){
        System.out.println("public void fly(int numbers)");
    }

    public void fly(short numbers){
        System.out.println("public void fly(short numbers)");
    }

    public boolean fly(){
        System.out.println("public boolean fly()");
        return false;
    }

    public void fly(int number1, int number2){
        System.out.println("public void fly(int number1, int number2)");
    }

    public void fly(int number1, short number2) throws RuntimeException, Exception {
        System.out.println("public void fly(int number1, short number2) throws RuntimeException, Exception");
    }

    /*public int fly(int numbers){
        System.out.println("public int fly(int numbers)");
        return 0;
    }*/


    /*public static int fly(int numbers){
        System.out.println("public int fly(int numbers)");
        return 0;
    }*/
}