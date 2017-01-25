package com.mtsmda.java8.certification.chapter4.order_of_initialization;

/**
 * Created by dminzat on 7/19/2016.
 */
public class InitDemoClass {

    public static void main(String[] args) {
        new LocalInitDemo();
/*
 expected:
 1 static init
2 static init
level - 2
1 init
Name1
Name2
2 init
level - 3
3 init
level - 4
Name3
level - 5

actual:
1 static init
2 static init
level - 2
1 init
Name1
Name2
2 init
level - 3
3 init
level - 4
Name3
level - 5
 */
        System.out.println("--------------------");
        System.out.println(LocalInitDemo.level);
        /*
        1 static init
        2 static init
        level - 2
        */
    }

}

class LocalInitDemo {
    {
        System.out.println("1 init");
//        System.out.println(name);
    }

    static {
        System.out.println("1 static init");
//        System.out.println(level);
    }

    protected static int level = 1;

    private String name = "Name1";

    static {
        System.out.println("2 static init");
        System.out.println("level - " + ++level);
    }


    {
        System.out.println(name);
        name = "Name2";
        System.out.println(name);
        System.out.println("2 init");
        System.out.println("level - " + ++level);
    }

    public LocalInitDemo() {
        name = "Name3";
        System.out.println(name);
        System.out.println("level - " + ++level);
    }

    {
        System.out.println("3 init");
        System.out.println("level - " + ++level);
    }

}