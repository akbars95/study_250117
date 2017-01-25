package com.mtsmda.java8.certification.chapter3;

import java.util.Arrays;

/**
 * Created by dminzat on 7/12/2016.
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int[] numbers1 = new int[3];
        printArray(numbers1);
        int[] numbers2 = new int[]{193, 56};
        printArray(numbers2);

        int [] numbers3 = {125, 82, 356, 356, 2};
        printArray(numbers3);

        int [] ids, type;

        ids = numbers1;
        type  = ids;

        int id2 [], type2;
        id2 = ids;
        type2 = type[0];

        System.out.println(id2.getClass().getCanonicalName());
        System.out.println("===============");

        String [] bugs = {"error", "warn", "debug"};
        String alias [] = bugs;
        System.out.println("bugs - " + bugs);
        System.out.println("bugs == alias - " + (bugs == alias));
        System.out.println("bugs.equals(alias) - " + bugs.equals(alias));

        int [] c1 = {12, 19};
        int [] c2 = {12, 19};
        System.out.println(c1.equals(c2));

        System.out.println(c1.toString());

        System.out.println(new Double[]{15.6}.toString());
        System.out.println(new double[]{15.6}.toString());
        System.out.println(bugs.getClass().getName());
        System.out.println(Arrays.toString(bugs));
        System.out.println(Arrays.toString(new int[]{}));
        int c[] = null;
        System.out.println(Arrays.toString(c));

        String [] strings = {"string Value"};
        Object [] objects = strings;
        Object o = strings;
        String [] againStrings = (String[]) objects;
//        againStrings[0] = new StringBuilder();
//        objects[0] = new StringBuilder();

        int arrayInt [] = new int[]{15, 05, -52, 43, 924};
        System.out.println(Arrays.toString(arrayInt));
        Arrays.sort(arrayInt);
        System.out.println(Arrays.toString(arrayInt));

        System.out.println("binary sort=================");
        int [] nums = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.binarySearch(nums, 2));//0
        System.out.println(Arrays.binarySearch(nums, 9));//-5
        System.out.println(Arrays.binarySearch(nums, 4));//1
        System.out.println(Arrays.binarySearch(nums, 8));//3
        System.out.println(Arrays.binarySearch(nums, 19));//-6
        System.out.println(Arrays.binarySearch(nums, 0));//-1

        System.out.println("-----binary search without sort");
        int [] numbersWithoutSort = {3, 2, 1};
        System.out.println(Arrays.binarySearch(numbersWithoutSort, 2));
        System.out.println(Arrays.binarySearch(numbersWithoutSort, 3));
        System.out.println(Arrays.binarySearch(numbersWithoutSort, 9));
    }

    private static final void printArray(int[] ints) {
        System.out.println("length = " + ints.length);
        for (int current : ints) {
            System.out.println(current);
        }
        System.out.println("---------------");
    }

}