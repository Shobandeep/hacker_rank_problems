package interviewPrepKit.string_manipulation.SherlockAndTheValidString;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {


    // Complete the isValid function below.
    /**
     * Method checks if all of the frequencies of the characters of the
     * provided string is the same or at most has 1 frequency a digit higher
     * than the others
     * constraints:
     *  the string only has characters [a-z] lowercase
     * @param s
     * @return
     */
    static String isValid(String s) {
        char[] charArray = s.toCharArray();
        int[] freqArray = new int[26];

        int maxFreq = 0;
        int secondMaxFreq = 0;

        for(int i = 0; i < charArray.length; i++)
            freqArray[charArray[i]-'a']++;

        for(int i = 0; i < freqArray.length; i++) {
            if(freqArray[i] >= maxFreq) {
                maxFreq = freqArray[i];
            }
            else if (freqArray[i] > secondMaxFreq)
                secondMaxFreq = freqArray[i];
        }

        int uniqueChars = 0;
        int maxFreqCount = 0;
        int secondMaxFreqCount = 0;

        for(int i = 0; i < freqArray.length; i++) {
            if(freqArray[i] != 0) {
                uniqueChars++;
                if(freqArray[i] == maxFreq)
                    maxFreqCount++;
                else if (secondMaxFreq != 0 && freqArray[i] == secondMaxFreq)
                    secondMaxFreqCount++;
                else
                    return "NO";
            }
        }
        

        // CASE 1: all chars have the same freq
        if(maxFreqCount == uniqueChars)
            return "YES";

        // CASE 2: there is one char that you can remove from the maxFreq so that
        // all char frequencies are equal
        if(maxFreqCount == 1 && secondMaxFreq == maxFreq-1)
            return "YES";
        // CASE 3: there is only one char in either freq that can be removed
        if( (secondMaxFreq == 1 && secondMaxFreqCount == 1) || (maxFreq == 1 && maxFreqCount == 1) )
            return "YES";


        // Default: all cases failed
        return "NO";
    }



    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();


            String s = scanner.next();
            System.out.println(s);
            System.out.println( isValid(s) );


            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


