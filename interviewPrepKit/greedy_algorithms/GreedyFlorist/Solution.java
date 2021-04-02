package interviewPrepKit.greedy_algorithms.GreedyFlorist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    /**
     * too hard to simplify, refer to link:
     * https://www.hackerrank.com/challenges/greedy-florist
     * NOTE: problem explained very poorly, the examples are deceptive
     * it's not (0 + 1) (1 + 1) (1 + 1) but (0 + 1) (1 + 1) (2 + 1)
     * either that or I'm lacking brain cells.
     * @param k
     * @param c
     * @return
     */
    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int totalCost = 0;

        if(k >= c.length)
            for(int flower: c)
                totalCost += flower;
        else {
            int priceMultiple = 1;
            // the number of times the price multiple has to be applied before resetting
            int kMod = 0;
            for(int i = c.length-1; i >= 0; i--) {
                if(kMod == k) {
                    kMod = 0;
                    priceMultiple++;
                }
                totalCost += c[i] * priceMultiple;
                kMod++;
            }
        }

        return totalCost;
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


            System.out.println( getMinimumCost(k, c) );


            System.out.println("The code took this long to execute: " + (endTime - startTime) );


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


