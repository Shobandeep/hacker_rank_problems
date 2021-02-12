package TenDaysOfSatistics.Day2;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    public static double weightedAverage(int[] array, int[] weightArray) {
        double average = 0;
        double weight = 0;
        for(int i = 0; i < array.length; i++) {
            average += array[i] * weightArray[i];
            weight += weightArray[i];
        }
        return average / weight;
    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] array = new int[length];
        int[] weightArray = new int[length];


        for(int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        for(int i = 0; i < length; i++) {
            weightArray[i] = scanner.nextInt();
        }
        
        DecimalFormat formatter = new DecimalFormat("#.0"); 
        System.out.println(formatter.format(weightedAverage(array, weightArray)));

        scanner.close();
    }
}
