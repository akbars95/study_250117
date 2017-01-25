package com.mtsmda.book.java8.other;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by dminzat on 1/20/2017.
 */
public class BitwiseOperations {


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(128, 79, 36, 25, 100, 83, 159);

        for (Sing sing : Sing.values()) {
            System.out.println("*****************************" + sing + "*************************************");
            integers.stream().forEach(integerOut -> {
                integers.stream().forEach(integerIn -> {
                    if (!integerIn.equals(integerOut)) {
                        Predicate<Sing> singPredicate = singCur -> singCur == Sing.LEFT_SHIFT || singCur == Sing.RIGHT_SHIFT || singCur == Sing.ZEOR_FILL_RIGHT_SHIFT;
//                        singPredicate.or(singCur -> singCur == Sing.RIGHT_SHIFT);
//                        singPredicate.or(singCur -> singCur == Sing.ZEOR_FILL_RIGHT_SHIFT);
                        if (singPredicate.test(sing)) {
//                            String curString = new String(integerIn + "");
//                            int i = Integer.parseInt(new Character(curString.charAt(curString.length() - 1)).toString());
                            core(integerOut, 2, sing);
                        } else {
                            core(integerOut, integerIn, sing);
                        }
                    }
                });
            });
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public static void core(int one, int two, Sing sing) {
        switch (sing) {
            case AND: {
                System.out.println("expression - (" + one + " " + sing.getSing() + " " + two + ") = " + (one & two));
            }
            break;
            case OR: {
                System.out.println("expression - (" + one + " " + sing.getSing() + " " + two + ") = " + (one | two));
            }
            break;
            case XOR: {
                System.out.println("expression - (" + one + " " + sing.getSing() + " " + two + ") = " + (one ^ two));
            }
            break;
            case COMPLIMENT: {
                System.out.println("expression - " + sing.getSing() + one + " = " + (~one));
            }
            break;
            case LEFT_SHIFT: {
                System.out.println("expression - (" + one + " " + sing.getSing() + " " + two + ") = " + (one << two));
            }
            break;
            case RIGHT_SHIFT: {
                System.out.println("expression - (" + one + " " + sing.getSing() + " " + two + ") = " + (one >> two));
            }
            break;
            case ZEOR_FILL_RIGHT_SHIFT: {
                System.out.println("expression - (" + one + " " + sing.getSing() + " " + two + ") = " + (one >>> two));
            }
            break;
        }
    }

    private enum Sing {
        AND("&"),
        OR("|"),
        XOR("^"),
        COMPLIMENT("~"),
        LEFT_SHIFT("<<"),
        RIGHT_SHIFT(">>"),
        ZEOR_FILL_RIGHT_SHIFT(">>>");

        Sing(String sing) {
            this.sing = sing;
        }

        private String sing;

        public String getSing() {
            return sing;
        }
    }

}