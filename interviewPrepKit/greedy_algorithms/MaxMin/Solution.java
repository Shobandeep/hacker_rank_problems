package interviewPrepKit.greedy_algorithms.MaxMin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the maxMin function below.
    /**
     * too hard to simplify, refer to link:
     * https://www.hackerrank.com/challenges/angry-childrenst
     * NOTE: you can just throw any int into arr', the numbers have to sorted
     *  Constraints:
     *  2 <= k >= arr.length
     * @param k
     * @param arr
     * @return
     */
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        if(k == arr.length)
            return arr[arr.length-1] - arr[0];

        int minDif = Integer.MAX_VALUE;
        for(int i = 0 ;i < arr.length-(k-1); i++) {
            int dif = arr[i+k-1] - arr[i];
            if(dif < minDif) {
                minDif = dif;
            }
        }

        return minDif;
    }


    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));


            int length = scanner.nextInt();
            int k = scanner.nextInt();
            int[] c = new int[length];
            for(int i = 0; i < length; i++) {
                c[i] = scanner.nextInt();
            }

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();


            System.out.println( maxMin(k, c) );


            System.out.println("The code took this long to execute: " + (endTime - startTime) );


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


