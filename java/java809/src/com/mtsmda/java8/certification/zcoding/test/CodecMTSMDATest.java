package com.mtsmda.java8.certification.zcoding.test;

import com.mtsmda.java8.certification.zcoding.CodecMTSMDA;
import com.mtsmda.java8.certification.zcoding.type.EnDecodeType;

/**
 * Created by dminzat on 7/22/2016.
 */
public class CodecMTSMDATest {

    //test piece
    private static void test(String input, EnDecodeType enDecodeType, boolean withDecode) {
        System.out.println("**************" + enDecodeType.name() + "***************");
        System.out.println("input - " + input);
        StringBuilder ionescu = CodecMTSMDA.encode(input, enDecodeType);
        System.out.println("result - " + ionescu);

        if (withDecode) {
            StringBuilder decode = CodecMTSMDA.decode(ionescu);
            System.out.println("decode - " + decode);
            System.out.println(input.equals(decode.toString()));
            test(input.equals(decode.toString()), enDecodeType);
            System.out.println("*************************************");
        }
    }

    private static void test(boolean test, EnDecodeType enDecodeType) {
        if (!test) {
            throw new RuntimeException("This " + enDecodeType.name() + " is false!");
        }
    }

    public static void main(String[] args) {
//        String[] testsData = {"thisIsPassword", "шчёя", "этоПароль", "!#df1253", CodecMTSMDA.getCharactersAsString().toString()};
        /*System.out.println("-----Experements begin-----");
        System.out.println(Character.isLetter('c'));
        System.out.println(Character.isLetter('5'));
        System.out.println(Character.isLetter('?'));
        System.out.println(Character.getNumericValue('4'));
        System.out.println("-----Experements end-----");

        List<Integer> integers = new ArrayList<>();
        for(int i = 0; i < 1_000; i++){
            integers.add(CodecMTSMDA.generateRandomWithBorders(1, 9));
        }
        Collections.sort(integers);
        System.out.println("min - " + integers.get(0));
        System.out.println("max - " + integers.get(integers.size() - 1));*/

        /*int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 100; i >= 0; i--) {*/
        /*EnDecodeType enDecodeType = EnDecodeType.SHIFT_RANDOM_EACH;
        System.out.println(enDecodeType.getCode());
        System.out.println(enDecodeType.getStringCode());*/
            /*if(i == 100){
                max = enDecodeType.getCode();
                min = enDecodeType.getCode();
            }*/
            /*if (enDecodeType.getCode() > max) {
                max = enDecodeType.getCode();
            }
            if (enDecodeType.getCode() < min) {
                min = enDecodeType.getCode();
            }*/

        /*}
        System.out.println("max = " + max);
        System.out.println("min = " + min);*/


//        test(testsData[3], EnDecodeType.SHIFT_RANDOM_EACH, true);
//        runTest(booleanValue("-t"));
        test("!#df1253", EnDecodeType.SHIFT_DEFAULT, booleanValue("t"));
    }

    private static boolean booleanValue(String booleanStr){
        if(booleanStr.equalsIgnoreCase("t")){
            return true;
        }
        return false;
    }

    /*private static final void runTest(boolean state) {
        String[] testsData = {"thisIsPassword", "шчёя", "этоПароль", "!#df1253", CodecMTSMDA.getCharactersAsString().toString()};

        if (state) {
            System.out.println("*****Test*****");


            for (EnDecodeType enDecodeType : EnDecodeType.values()) {
                System.out.println("\n////////////////////////////////\n");
                for (String testData : testsData) {
                    test(testData, enDecodeType, true);
                }
                System.out.println("\n////////////////////////////////\n");
            }
            System.out.println("*****Test*****");
        }
    }*/

}