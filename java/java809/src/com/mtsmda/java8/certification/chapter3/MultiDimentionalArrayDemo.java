package com.mtsmda.java8.certification.chapter3;

/**
 * Created by dminzat on 7/13/2016.
 */
public class MultiDimentionalArrayDemo {

    public static void main(String[] args) {
        int[][] vars1 = {};
        int vars2[][] = {};
        int[] vars3[] = {};
        int[] vars3_5 = {}, vars4[] = {}, space[][] = {};
        System.out.println("vars1 - " + vars1.getClass().getCanonicalName());
        System.out.println("vars2 - " + vars2.getClass().getCanonicalName());
        System.out.println("vars3 - " + vars3.getClass().getCanonicalName());
        System.out.println("vars3_5 - " + vars3_5.getClass().getCanonicalName());
        System.out.println("vars4 - " + vars4.getClass().getCanonicalName());
        System.out.println("space - " + space.getClass().getCanonicalName());

        int[][] mda = new int[2][];
        mda[0] = new int[9];
        mda[1] = new int[97];

        int[][][][] d4Array = new int[1][][][];
        d4Array[0] = new int[1][][];
        d4Array[0][0] = new int[1][];
        d4Array[0][0][0] = new int[9];
        for (int i = 0; i < d4Array.length; i++) {
            for (int j = 0; j < d4Array[i].length; j++)
                for (int y = 0; y < d4Array[i][j].length; y++)
                    for (int z = 0; z < d4Array[i][j][y].length; z++) {
                        d4Array[i][j][y][z] = new Double(Math.random() * 100).intValue();
                        System.out.println("d4Array[" + i + "][" + j + "][" + y + "][" + z + "] " + d4Array[i][j][y][z]);
                        /*if(z != d4Array[i][j][y].length - 1){
                            System.out.print(", ");
                        }*/
                    }
        }
    }

}