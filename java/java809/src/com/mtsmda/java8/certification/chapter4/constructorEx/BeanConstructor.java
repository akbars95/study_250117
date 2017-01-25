package com.mtsmda.java8.certification.chapter4.constructorEx;

/**
 * Created by dminzat on 7/18/2016.
 */
public class BeanConstructor {

    public static void main(String[] args) {
        new Bunny("red");
        new Bunny("green", 150, 250);

        System.out.println(new Mouse(197).toString());
    }

}

class Bunny {
    private String color;
    private int height;
    private int length;

    public Bunny() {
        super();
    }

    public Bunny(String color) {
        /*this.*/
        color = color;
        System.out.println("this.color - " + this.color);
        System.out.println("color - " + color);
    }

    public Bunny(String color, int height, int length) {
//        System.out.println("here");
        this();
        this.color = color;
        this.height = height;
        this.length = length;
//        new Bunny(color, height, length);
        new Bunny(color);
    }
}

class Mouse {
    private int x;
    private int y;
    private int z;

    public Mouse(int x) {
        this(x, 5);
    }

    public Mouse(int x, int y) {
        this(x, y, 19);
    }

    public Mouse(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

}