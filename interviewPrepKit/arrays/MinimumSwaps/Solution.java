package interviewPrepKit.arrays.MinimumSwaps;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;

        int temp;
        int limit = (arr.length / 2 == 0) ? arr.length / 2 : (arr.length / 2)+1;
        while(limit != 0) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != i+1) {
                    temp = arr[i];
                    arr[i] = arr[temp-1];
                    arr[temp-1] = temp;
                    swaps++;
                }
            }
            limit = limit / 2;
        }


//        for(int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//
//        System.out.println(swaps);

        return swaps;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 2, 4, 6, 7};

        minimumSwaps(arr);
    }
}


