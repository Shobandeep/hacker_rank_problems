import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

//     Complete the reverseShuffleMerge function below.
    /**
     * summary of method  at: https://www.hackerrank.com/challenges/reverse-shuffle-merge
     * @param s
     * @return
     */
    static String reverseShuffleMerge(String s) {
        int[] totalFreq = new int[26];
        char[] sArray = s.toCharArray();
        for(char c: sArray)
            totalFreq[c-'a']++;

        int[] charsLeft = new int[26];
        for(int i = 0; i < totalFreq.length; i++)
            if(totalFreq[i] != 0)
                charsLeft[i] = totalFreq[i] / 2;
        char[] result = new char[s.length()/2];
        result[0] = sArray[sArray.length-1];
        charsLeft[result[0]-'a']--;
        totalFreq[result[0]-'a']--;
        int current = 1;

        for(int i = sArray.length-2; i >= 0; i--) {
            // if the current char hasn't been used in the string
            if(charsLeft[sArray[i] - 'a'] != 0) {
                    // if the next char is greater, we'll add it and keep going
                    // if the next char is smaller and the current char can be found later in the string
                    // we replace them and add it again later in the string, we go back as far as this condition holds!
                    while (current != 0
                            && (totalFreq[result[current - 1] - 'a'] - charsLeft[result[current - 1] - 'a']) != 0
                            && sArray[i] < result[current - 1]
                    ) {
                        current--;
                        charsLeft[result[current] - 'a']++;
                    }
                    if (current != result.length) {
                        result[current] = sArray[i];
                        charsLeft[sArray[i] - 'a']--;
                        current++;
                    }
            }
            totalFreq[sArray[i] - 'a']--;
        }

        return new String(result);
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File(args[0]));

        String s = scanner.nextLine();


        System.out.println( reverseShuffleMerge(s));

        scanner.close();
    }
}
