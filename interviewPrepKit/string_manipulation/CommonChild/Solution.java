package interviewPrepKit.string_manipulation.CommonChild;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {



    // Complete the commonChild function below.
    /**
     * method returns the common substring between two strings of
     * equal length, 0 or more characters may be removed from either string
     * to get the common substring. Letters cannot be rearranged.
     * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem#Complexity
     * @param s1
     * @param s2
     * @return
     */
    static int commonChild(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        int length = s1Array.length;

        int[][] commonSequence = new int[length+1][length+1];
        for(int i = 1; i <= length; i++) {
            for(int j = 1; j <= length; j++) {
                if(s1Array[i-1] == s2Array[j-1])
                    commonSequence[i][j] = commonSequence[i - 1][j - 1] + 1;
                else
                    commonSequence[i][j] = Math.max(commonSequence[i-1][j], commonSequence[i][j-1]);
            }
        }


        return commonSequence[length][length];
    }





    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();



            String s1 = scanner.next();
            String s2 = scanner.next();

            System.out.println( commonChild(s1, s2) );


            System.out.println("The code took this long to execute: " + (endTime - startTime) );


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


