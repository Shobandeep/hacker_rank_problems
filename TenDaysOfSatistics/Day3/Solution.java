package TenDaysOfSatistics.Day3;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    public static double mean(int[] array) {
        double mean = 0;
        for(int i = 0; i < array.length; i++) {
            mean += array[i];
        }

        return mean / array.length;
    }

    public static double standardDeviation(int[] array) {
        double mean = mean(array);
        double squaredDistanceSum = 0;

        for(int i = 0; i < array.length; i++) {
            squaredDistanceSum += Math.pow((array[i]-mean), 2);
        }

        return Math.sqrt(squaredDistanceSum / array.length);
    }




    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] array = new int[length];


        for(int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        
        DecimalFormat formatter = new DecimalFormat("#.0"); 
        System.out.println(formatter.format(standardDeviation(array)));

        scanner.close();
    }
}
