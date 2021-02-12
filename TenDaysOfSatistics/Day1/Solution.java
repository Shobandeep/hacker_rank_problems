package TenDaysOfSatistics.Day1;

import java.io.*;
import java.util.*;

public class Solution {

    public static double mean(int[] array) {
        double mean = 0;
        for(int i = 0; i < array.length; i++) {
            mean += array[i];
        }

        return mean / array.length;
    }

    public static double median(int[] array) {
        double median = 0;
        Arrays.sort(array);
        if(array.length % 2 == 1) {
            median = array[array.length/2];
        }
        else {
            median = (double)(array[array.length/2] + array[array.length/2 - 1]) / 2;
        }

        return median;
    }

    public static int mode(int[] array) {
        int modeIndex = 0;
        int maxCount = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < array.length; i++) {
            int count = map.getOrDefault(array[i], 0);
            if(count == 0) {
                map.put(array[i], 1);
            }
            else {
                map.put(array[i], count+1);
            }
            count++;
            if(count > maxCount) {
                maxCount = count;
                modeIndex = i;
            }
            else if (count == maxCount && array[modeIndex] > array[i]) {
                    modeIndex = i;
            }

        }

        return array[modeIndex];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] array = new int[length];


        for(int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        
        System.out.println(mean(array));
        System.out.println(median(array));
        System.out.println(mode(array));

        scanner.close();
    }
}
