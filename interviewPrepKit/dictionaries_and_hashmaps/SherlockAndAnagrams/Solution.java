package interviewPrepKit.dictionaries_and_hashmaps.SherlockAndAnagrams;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int anagramCount = 0;
        HashMap<String, Integer> map = new HashMap<>();

        int length = s.length();
        int wordSize = 1;
        while (wordSize != length) {
            for(int i = 0; i <= length-wordSize; i++) {
                char[] charArray = s.substring(i, i+wordSize).toCharArray();
                Arrays.sort(charArray);
                String sortedWord = new String(charArray);
                Integer num = map.get(sortedWord);
                if(num == null)
                    map.put(sortedWord, 1);
                else {
                    map.put(sortedWord, num+1);
                    anagramCount += num;
                }
            }
            wordSize++;
        }

        return anagramCount;
    }


    public static void main(String[] args) {

        String s1 = "abba";


        long startTime = System.nanoTime();

        long endTime = System.nanoTime();
        System.out.println( sherlockAndAnagrams(s1) );
        System.out.println("The code took this long to execute: " + (endTime - startTime) );
    }
}




