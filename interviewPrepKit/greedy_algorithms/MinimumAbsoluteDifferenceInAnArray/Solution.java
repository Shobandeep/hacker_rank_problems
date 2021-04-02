package interviewPrepKit.greedy_algorithms.MinimumAbsoluteDifferenceInAnArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {



//    // Complete the minimumAbsoluteDifference function below.
//    /**
//     * method finds the minimum difference between two numbers in an array
//     * O(n^2) takes too long
//     * @param arr
//     * @return
//     */
//    static int minimumAbsoluteDifference(int[] arr) {
//        int minDif = Integer.MAX_VALUE;
//
//        for(int i = 0; i < arr.length; i++)
//            for(int j = i+1; j < arr.length; j++) {
//                minDif = Math.min(Math.abs(arr[i] - arr[j]), minDif);
//            }
//
//        return minDif;
//    }

    // Complete the minimumAbsoluteDifference function below.
    /**
     * method finds the minimum difference between two numbers in an array
     * @param arr
     * @return
     */
    static int minimumAbsoluteDifference(int[] arr) {
        int minDif = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length-1; i++)
            minDif = Math.min(Math.abs(arr[i] - arr[i+1]), minDif);
        return minDif;
    }






    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();



            int length = scanner.nextInt();
            int[] array = new int[length];

            for(int i = 0; i < length; i++)
                array[i] = scanner.nextInt();
            System.out.println( minimumAbsoluteDifference(array) );


            System.out.println("The code took this long to execute: " + (endTime - startTime) );


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


