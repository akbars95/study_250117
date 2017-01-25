package com.mtsmda.java8.certification.chapter2.javaStatements;

/**
 * Created by dminzat on 7/7/2016.
 */
public class ContinueSt {

    public static void main(String[] args) {
        FIRST_CHAR_LOOP: for (int a = 1; a <= 4; a++){
            for(char x = 'a'; x <= 'c'; x++){
                if(a == 2 || x == 'b'){
                    continue FIRST_CHAR_LOOP;
                }
                System.out.print("a = " + a + "\tx = " + x + "\n_______________");
                System.out.println();
            }
        }
        System.out.println("Done");
    }

}
