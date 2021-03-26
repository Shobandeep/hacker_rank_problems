package interviewPrepKit.string_manipulation.MakingAnagrams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the countInversions function below.

    /**
     * the method finds the minimum characters that need to be deleted
     * from both strings in order to make the strings anagrams of each
     * Constraints:
     *  string will be [a-z] all lower case
     *  string length is between 1 and 10^4
     * @param a
     * @param b
     * @return
     */
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int deletedCharCount = 0;
        int[] freqArray = new int[26];
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();

        for(int i = 0; i < aCharArray.length; i++)
            freqArray[aCharArray[i]-'a']++;
        for(int i = 0; i < bCharArray.length; i++)
            freqArray[bCharArray[i]-'a']--;

        System.out.println(Arrays.toString(freqArray));
        for(int i = 0; i < freqArray.length; i++)
            deletedCharCount += Math.abs(freqArray[i]);

        return deletedCharCount;
    }



    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            String a = scanner.nextLine().trim();
            String b = scanner.nextLine().trim();





            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            System.out.println( makeAnagram(a, b) );
            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


