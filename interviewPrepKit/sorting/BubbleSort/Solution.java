package interviewPrepKit.sorting.BubbleSort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    /**
     * bubble sort algorithm that also prints the number of swaps completed
     * @param a - array to be sorted
     */
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int temp;
        int totalSwaps = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-1; j++) {
                if(a[j] > a[j+1]) {
                    totalSwaps++;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println("Array is sorted in "+ totalSwaps +" swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);

    }




    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            int length = scanner.nextInt();

            int[] arr = new int[length];

            for(int i = 0; i < length; i++)
                arr[i] = scanner.nextInt();



            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            countSwaps(arr);
            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


