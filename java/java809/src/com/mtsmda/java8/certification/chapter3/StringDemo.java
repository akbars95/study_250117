package com.mtsmda.java8.certification.chapter3;

/**
 * Created by dminzat on 7/8/2016.
 */
public class StringDemo {

    public static void main(String[] args) {
        System.out.println(1 + 3);//4
        System.out.println("1" + 3);//13
        System.out.println("1" + 3 + 5);//135
        System.out.println("1" + (3 + 9));//112

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);//64


        String s = "1";
        s += "2";
        s += "3";
        System.out.println(s);

        Mutable mutable = new Mutable();
        mutable.setText("ion");
        System.out.println(mutable.getText());

        Immutable immutable = new Immutable("Vasya");
        System.out.println(immutable.getText());


        System.out.println("===================");

        String animals = "animals";
        System.out.println(animals.length());

        System.out.println("first letter - " + animals.charAt(0));
        for (int i = 1; i < animals.length() - 1; i++){
            System.out.println("index [" + i + "] = " + animals.charAt(i));
        }
        System.out.println("last letter - " + animals.charAt(animals.length() - 1));

        try{
            animals.charAt(19);
        }catch (Exception e){
            System.out.println(e.getClass().getName());
        }

        System.out.println("-----indexOf-----");
        System.out.println(animals.indexOf('l'));
        System.out.println(animals.indexOf('a'));
        System.out.println(animals.indexOf('a', 1));
        System.out.println(animals.indexOf("s"));
        System.out.println(animals.indexOf("a", 2));
        System.out.println(animals.indexOf("im", 9));


        System.out.println("-----substring-----");
        System.out.println(animals);
        System.out.println(animals.substring(2));
        System.out.println(animals.substring(2, 4));
        System.out.println("reverse");
        for (int i = animals.length() - 1; i >= 0; i--){
            System.out.print(animals.charAt(i));
        }
        System.out.println("\n");
        for(int i = 0; i < animals.length(); i++){
            System.out.println(animals.substring(i));
        }

        for(int i = animals.length() - 1; i >= 0 ; i--){
            System.out.println(animals.substring(i));
        }

        System.out.println();
        for(int i = 0; i < animals.length(); i++){
            String temp = new String("" + animals.charAt(i));
            if(i % 2 == 0){
                System.out.print(temp.toUpperCase());
                continue;
            }
            System.out.print(temp);
        }
        System.out.println();

        System.out.println("animals.substring(3, 3) - " + animals.substring(3, 3) + "\t" + animals.substring(3, 3).isEmpty());
        try {
            System.out.println(animals.substring(3, 2));
            System.out.println(animals.substring(3, 9));
        }catch(Exception e){
            System.out.println(e.getClass().getName());
        }


        System.out.println("-----contains-----");
        System.out.println(animals.contains("a"));
        System.out.println(animals.contains("mal"));
        System.out.println(animals.contains("mol"));
        System.out.println(animals.contains("maL"));


        System.out.println("-----contains-----");
        System.out.println(animals.replace("a", "A9"));
        System.out.println(animals.replace("Ё", "A9"));

        System.out.println(animals.trim());
        String trim = "  f  f   \n\t\r\b";
        System.out.println("length = " + trim.length());
        System.out.println(trim.trim() + " - " + trim.trim().length());

        System.out.println(new String("Dima").matches("([\\w]*)"));
    }

}

class Mutable{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

final class Immutable{

    private String text;

    public Immutable(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}