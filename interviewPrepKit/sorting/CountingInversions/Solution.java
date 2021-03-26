package interviewPrepKit.sorting.CountingInversions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the countInversions function below.
    /**
     * method uses merge sort to count the number of swaps required to sort an array
     * @param arr : array to be sorted
     * @return
     */
    static long totalSwaps = 0;
    static long countInversions(int[] arr) {
        totalSwaps = 0;

        countingMergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        return totalSwaps;
    }

    static void countingMergeSort(int[] arr, int start, int end) {
        if(start >= end)
            return;

        int middle = (start + end) / 2;
        // left
        countingMergeSort(arr, start, middle);
        // right
        countingMergeSort(arr, middle+1, end);

        merge(arr, start, middle, end);
    }

    static void merge(int[] arr, int start, int middle, int end) {
        int[] sortedArr = new int[(end-start) + 1];

        int i = 0, leftIndex = start, rightIndex = middle+1, swapsDone = 0;
        while(leftIndex <= middle && rightIndex <= end) {

            if(arr[leftIndex] > arr[rightIndex]) {
                // the difference in the indexes is how far the bigger value had to
                // 'travel' to the left which is also equal to the number of swaps
                // we also want to account for the distance that could have been lowered because of previous swaps
                totalSwaps += rightIndex - leftIndex - swapsDone;
                swapsDone++;
                sortedArr[i++] = arr[rightIndex++];
            }

            else {
                sortedArr[i++] = arr[leftIndex++];

            }
        }

        while(rightIndex <= end)
            sortedArr[i++] = arr[rightIndex++];

        while(leftIndex <= middle)
            sortedArr[i++] = arr[leftIndex++];


        // copy temp back into original array
        i = start;
        for(int j = 0; j < sortedArr.length; i++,j++)
            arr[i] = sortedArr[j];
    }




    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            int d = scanner.nextInt();

            for(int i = 0; i < d; i++) {
                int length = scanner.nextInt();
                int[] arr = new int[length];
                for(int j = 0; j < length; j++)
                    arr[j] = scanner.nextInt();

                System.out.println(countInversions(arr));
            }






//            long startTime = System.nanoTime();
//            long endTime = System.nanoTime();
//
//            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


