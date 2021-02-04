package interviewPrepKit.arrays.HourglassSum;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourGlassSum = 0;
        int hourGlassSum = 0;
        int rowLength = arr[0].length;
        int colLength = arr.length;
        // if we don't have the dimensions for atleast one hour glass, return 0;
        if(rowLength < 3 || colLength < 3)
            return maxHourGlassSum;
        int row = 0, col = 0;
        maxHourGlassSum =
                arr[col][row] + arr[col][row+1] + arr[col][row+2]
                        + arr[col+1][row+1] +
                arr[col+2][row] + arr[col+2][row+1] + arr[col+2][row+2];
        if(rowLength < 4)
            col++;
        else
            row++;
        for(; col < arr[0].length-2;col++) {
            for(; row < arr.length-2;row++) {
                hourGlassSum =
                        arr[col][row] + arr[col][row+1] + arr[col][row+2]
                                + arr[col+1][row+1] +
                        arr[col+2][row] + arr[col+2][row+1] + arr[col+2][row+2];
                if(hourGlassSum > maxHourGlassSum)
                    maxHourGlassSum = hourGlassSum;
            }
            row = 0;
        }

        return maxHourGlassSum;
    }


    public static void main(String[] args) {

        int[][] arr = {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        };

        System.out.println(hourglassSum(arr));
        // expected 19
    }

}



