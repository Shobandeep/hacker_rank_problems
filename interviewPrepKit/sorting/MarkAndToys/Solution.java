package interviewPrepKit.sorting.MarkAndToys;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int maxToys = 0;
        Arrays.sort(prices);
        int i = 0;
        while(k > prices[i]) {
            k -= prices[i++];
            maxToys++;
        }
        return maxToys;
    }


    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            int length = scanner.nextInt();
            int budget = scanner.nextInt();

            int[] prices = new int[length];

            for(int i = 0; i < length; i++)
                prices[i] = scanner.nextInt();



            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            System.out.println( maximumToys(prices, budget) );
            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


