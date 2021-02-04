package interviewPrepKit.arrays.ArrayManipulation;

public class Solution {

    // Complete the arrayManipulation function below.
    // aprox 16-17k nano seconds
    static long arrayManipulationBrute(int n, int[][] queries) {
        long max = 0;
        long[] array = new long[n+1];

        for(int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            for(int j = a; j <= b; j++) {
                array[j] += k;
                if(array[j] > max)
                    max = array[j];
            }
        }


        return max;
    }

    // Complete the arrayManipulation function below.
    // aprox 7k nano seconds
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        long[] array = new long[n+1];

        for(int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1];
            int k = queries[i][2];

            array[a] += k;
            array[b] -= k;
        }

        long runningTotal = 0;
        for(int i = 0; i < array.length; i++) {
            runningTotal += array[i];
            if(runningTotal > max)
                max = runningTotal;
        }

        return max;
    }

    public static void main(String[] args) {

//        int n = 10;
//        int[][] arr = {
//                { 1, 5, 3 },
//                { 4, 8, 7 },
//                { 6, 9, 1 }
//        };

        int n = 40;
        int[][] arr = {
                { 29, 40, 787 },
                { 9 , 26 , 219 },
                { 21,  31,  214 },
                { 8 , 22 , 719 },
                { 15,  23,  102 },
                { 11,  24,  83 },
                { 14,  22,  321 },
                { 5 , 22 , 300 },
                { 11,  30,  832 },
                { 5 , 25 , 29 },
                { 16,  24,  577 },
                { 3 , 10 , 905 },
                { 15,  22,  335 },
                { 29,  35,  254 },
                { 9 , 20 , 20 },
                { 33,  34,  351 },
                { 30,  38,  564 },
                { 11,  31,  969 },
                { 3 , 32 , 11 },
                { 29,  35,  267 },
                { 4 , 24 , 531 },
                { 1 , 38 , 892 },
                { 12,  18,  825 },
                { 25,  32,  99 },
                { 3 , 39 , 107 },
                { 12,  37,  131 },
                { 3 , 26 , 640 },
                { 8 , 39 , 483 },
                { 8 , 11 , 194 },
                { 12,  37,  502 }
        };

        long time = System.nanoTime();


        arrayManipulation(n, arr);

        System.out.println(System.nanoTime() - time);
    }
}


