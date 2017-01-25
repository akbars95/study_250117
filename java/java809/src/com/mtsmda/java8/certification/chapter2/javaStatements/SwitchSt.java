package com.mtsmda.java8.certification.chapter2.javaStatements;

/**
 * Created by dminzat on 7/7/2016.
 */
public class SwitchSt {

    public static void main(String[] args) {
        switchDemo();
    }

    private static void switchDemo() {
        int dayOfWeek = 5;
        switch (dayOfWeek) {
            default:
                System.out.println("Week day");
                break;
            case 6: {
                System.out.println("Saturday");
            }
            break;
            case 7: {
                System.out.println("Sunday");
            }
            break;
        }

        System.out.println("====================");

        int note = 9;
        switch (note) {
            case 10:
                System.out.println("excellent");
                break;
            case 9:
            case 8:
                System.out.println("good");
                break;
            case 7:
            case 6:
                System.out.println("satisfactorily");
                break;
            case 5:
                System.out.println("not satisfactorily");
                break;
            default:
                System.out.println("bad");
                break;
        }

    }

    private static int getSortOrder(String firstname, final String lastname) {
        String middlename = "ION";
        final String suffix = "JR";
        int id = 0;

        switch (firstname) {
            case "Test": {
                id = 52;
            }
            break;
           /* case middlename: {
                id = 17;
            }
            break;*/
            case suffix: {
                id = 19;
            }
            break;
            /*case lastname: {
                id = 953;
            }
            break;*/
        }

        return id;
    }

}