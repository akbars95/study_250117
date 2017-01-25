package com.mtsmda.java8.certification.chapter2.javaStatements;

/**
 * Created by dminzat on 7/7/2016.
 */
public class BreakSt {

    public static void main(String[] args) {
        int [][] array2 = {{1, 13, 19}, {2, 9}, {25,853,2,0}, {29, 25}};
        int searchValue = 25;
        int positionX = -1;
        int positionY = -1;

        PARENT_LOOP: for(int i = 0; i < array2.length; i++){
            for (int j = 0; j < array2[i].length; j++){
                if(array2[i][j] == searchValue){
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;
                }
            }
        }
        if(positionX == -1 || positionY == -1){
            System.out.println("Value " + searchValue + " is not found!");
        }else{
            System.out.println("Value " + searchValue + " is found and and located on (" + (positionX + "," + positionY) + ")");
        }
    }

}