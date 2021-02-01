package LeftArrayRotation;

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int acutalRotations = a.length - (d % a.length);
        int newPosition;
        int[] rotatedArray = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            newPosition = (i + acutalRotations) % a.length;
            rotatedArray[newPosition] = a[i];
        }
        return rotatedArray;
    }


    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };

        int d = 4;

        rotLeft(arr, d);
        // expected 5 1 2 3 4
    }

}



